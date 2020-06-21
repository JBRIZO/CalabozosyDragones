package Proyectos;

import java.util.Random;
import java.util.Scanner;

public class Heroe
{
    private String nombre;
    private int pociones = 3;
    private int vida = 100;
    private int experiencia = 0;
    private  boolean defender = false;
    private int turnos = 3;

    public boolean isDefender() {
        return defender;
    }

    public void setDefender(boolean defender) {
        this.defender = defender;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPociones() {
        return  pociones;
    }

    public void setPociones(int pociones) {
        this.pociones = pociones;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void atacar(Cuarto cuarto)
    {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        if (cuarto.getNumEnemigos() == 0)
        {
            System.out.println("No hay enemigos para atacar");
        }else
            {
                System.out.println("¿A que enemigo desea atacar? (Escriba el numero)");
                int  opc = sc.nextInt();
                if (opc == 1)
                {
                    int atk = (int)(r.nextDouble()*15+1);
                    cuarto.getEnemigos(0).setVida(cuarto.getEnemigos(0).getVida() - atk );
                    System.out.println("Atacas a "+ cuarto.getEnemigos(0).getNombre() + " y ejerces " + atk + " puntos de daño!!");
                    if (cuarto.getEnemigos(0).getVida() < 1)
                    {
                        cuarto.getEnemigos(0).setVivo(false);
                        System.out.println("¡Has eliminado un enemigo!");
                        System.out.println("+100 EXP");
                        experiencia = experiencia +100;
                        if (cuarto.getEnemigos(0).getPocion() == 1)
                        {
                            cuarto.setNumPociones(cuarto.getNumPociones() + 1);
                        }
                    }else
                        {
                            if (defender)
                            {
                                System.out.println("¡Te defiendes del ataque del enemigo!");
                                defender = false;
                            }else
                            {
                                cuarto.getEnemigos(0).atacar(this);
                                turnos++;
                            }
                        }
                }else
                    {
                        if (opc == 2)
                        {
                            int atk = (int)(r.nextDouble()*15+1);
                            cuarto.getEnemigos(1).setVida(cuarto.getEnemigos(1).getVida() - atk);
                            System.out.println("Atacas a "+ cuarto.getEnemigos(1).getNombre() + " y ejerces " + atk + " puntos de daño!!");

                        }
                        if (cuarto.getEnemigos(1).getVida() < 1)
                        {
                            cuarto.getEnemigos(1).setVivo(false);
                            System.out.println("¡Has eliminado un enemigo!");
                            System.out.println("+100 EXP");
                            experiencia = experiencia +100;
                            if (cuarto.getEnemigos(1).getPocion() == 1)
                            {
                                cuarto.setNumPociones(cuarto.getNumPociones() + 1);
                            }
                        }else
                            {
                                cuarto.getEnemigos(1).atacar(this);
                                turnos++;
                            }
                    }
            }
    }

    public void recogerPocion (Cuarto cuarto)
    {
        pociones = pociones + 1;
        cuarto.setNumPociones(cuarto.getNumPociones() - 1);
        System.out.println("Has recogido una pocion");
    }

    public void usarPocion()
    {
        if (vida == 100)
        {
            System.out.println("Ya tienes el maximo de vida");
        }else
            {
                if (pociones < 1)
                {
                    System.out.println("No hay pociones para tomar.");
                }else
                {
                    pociones = pociones - 1;
                    vida =vida + 20;
                    System.out.println("Has tomado una pocion, tu salud ha incrementado en 20 pts.");
                }
            }


    }
    public void defender ()
    {
        if ((turnos%3) == 0)
        {
            System.out.println("El siguiente turno te defiendes de los ataques de los enemigos");
            turnos++;
            defender = true;
        }else
            {
                System.out.println("Todavia no te puedes defender");
            }

    }

}
