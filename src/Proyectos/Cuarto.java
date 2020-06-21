package Proyectos;

import java.util.ArrayList;
import java.util.Random;

public class Cuarto
{
    Random r = new Random();
    private int numEnemigos = r.nextInt(3);
    private Enemigo[] enemigos = new Enemigo[2];
    private int numPociones;

    public  void agregarEnemigos1(Enemigo enemigo)
    {
            enemigos[0] = enemigo;
    }

    public void agregarEnemigos2(Enemigo enemigo, Enemigo enemigo2)
    {
        enemigos[0] = enemigo;
        enemigos[1] = enemigo2;
    }

    public Enemigo getEnemigos(int indice) {
        return enemigos[indice];
    }

    public void setEnemigos(Enemigo enemigo, int indice) {
        this.enemigos[indice] = enemigo;
    }

    public int getNumEnemigos() {
        return numEnemigos;
    }

    public void setNumEnemigos(int numEnemigos) {
        this.numEnemigos = numEnemigos;
    }


    public int getNumPociones() {
        return numPociones;
    }

    public void setNumPociones(int numPociones) {
        this.numPociones = numPociones;
    }

    public void mostrarEnemigos()
    {
        if (numEnemigos == 0)
        {
            System.out.println("No hay enemigos en este cuarto");
        }else
            {
             System.out.println("Enemigos:");
             if (numEnemigos == 1)
                    {
                        if (enemigos[0].getVida() < 1 )
                        {
                            System.out.println("Enemigo DERROTADO");
                        }else
                        {
                            System.out.println((1) + ". " + enemigos[0].getNombre() + "| HP: " + enemigos[0].getVida());
                        }
                    }else
                        {
                            if (numEnemigos == 2)
                            {
                                for (int i = 0; i <= (numEnemigos - 1); i++)
                                {
                                    if (enemigos[i].getVida() < 1)
                                    {
                                        System.out.println("Enemigo DERROTADO");
                                    }else
                                    {
                                        System.out.println((i+1) + ". " + enemigos[i].getNombre() + "| HP: " + enemigos[i].getVida());

                                    }
                                }
                            }
                        }
                }
    }
    public void mostrarPociones()
    {
        if (numPociones == 0)
        {
            System.out.println("No hay pociones para recoger");
        }else {
                    System.out.println("En este cuarto hay " + numPociones +" pocion.");
                }
    }

}

