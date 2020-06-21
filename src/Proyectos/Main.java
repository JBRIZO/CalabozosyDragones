package Proyectos;

import java.util.ArrayList;
import java.util.*;

public class Main {
    public static ArrayList<Cuarto> cuartos = new ArrayList<>();

    public static void main(String[] args) {
        Heroe heroe = new Heroe();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        generarCuartos();
        System.out.println("Bienvenido(a) a calabozos y dragones, estos son tus controles:");
        System.out.println("Mirar: Muestra cuantos enemigos y pociones hay en el cuarto.");
        System.out.println("Recoger: Te permite recoger una pocion");
        System.out.println("Avanzar: Te permite salir por la entrada norte hacia otro cuarto.");
        System.out.println("Retroceder: Te permite salir por la salida sur hacia otro cuarto.");
        System.out.println("Derecha: Te permite salir del cuarto por la salida este hacia otro cuarto");
        System.out.println("Izquierda: Te permite salir del cuarto por la salida oeste hacia otro cuarto");
        System.out.println("Atacar: Ataque un enemigo al azar.");
        System.out.println("Defender: te defiendes por un turno del ataque enemigo.");
        System.out.println("Usar: usas una pocion de las que has acumulado");
        System.out.println("Heroe: puedes ver el numero de pociones que llevas contigo y tu salud");
        System.out.println("¡Empezemos!");
        System.out.println(" ");
        System.out.println(" ");
        System.out.print("Has entrado al calabozo.");
        boolean salir = false;
        while (!salir) {
            try {
                int num;
                num = r.nextInt(6);
                cuartos.get(num);
                System.out.println(" Ahora te encuentras en el cuarto: " + (num+1));
                System.out.println("¿Que deseas hacer?");
                boolean salir2 = false;
                while (!salir2) {
                    String opcion = sc.next();
                    switch (opcion) {
                        case "mirar":
                            cuartos.get(num).mostrarEnemigos();
                            cuartos.get(num).mostrarPociones();
                            break;
                        case "recoger":
                            heroe.recogerPocion(cuartos.get(num));
                            break;
                        case "avanzar":
                            num = r.nextInt(6);
                            System.out.println("Ahora estas en el cuarto " + (num + 1));
                            break;
                        case "retroceder":
                            num = r.nextInt(6);
                            System.out.println("Ahora estas en el cuarto " + (num + 1));
                            break;
                        case "derecha":
                            num = r.nextInt(6);
                            System.out.println("Ahora estas en el cuarto " + (num + 1));
                            break;
                        case "izquierda":
                            num = r.nextInt(6);
                            System.out.println("Ahora estas en el cuarto " + (num + 1));
                            break;
                        case "atacar":
                            heroe.atacar(cuartos.get(num));
                            if (heroe.getVida() < 1)
                            {
                                System.out.println("********************************************************************");
                                System.out.println("Has sido derrotado");
                                System.out.println("Has conseguido " + heroe.getExperiencia() + " puntos de experiencia");
                                salir2 = true;
                            }
                            break;
                        case "defender":
                            heroe.defender();
                            break;
                        case "usar":
                            heroe.usarPocion();
                            break;
                        case "heroe":
                            break;
                        default:
                            System.out.println("No conozco esa palabra");
                    }
                }
                salir = true;
            } catch (InputMismatchException e) {
                System.out.println("No conozco esa palabra ");
            }
        }
    }

    public static void generarCuartos() {
        for (int i = 0; i < 6; i++) {
            Cuarto cuarto = new Cuarto();
            generarEnemigo(cuarto);
            cuartos.add(cuarto);
        }
    }

    public static void generarEnemigo(Cuarto cuarto) {
        Random r = new Random();
        String[] nombres = {"Esqueleto", "Zombie", "Dragon", "Guerrero", "Asesino"};
        if (cuarto.getNumEnemigos() == 1) {
            Enemigo enemigo = new Enemigo();
            enemigo.setVida(((int)(r.nextDouble() * 20 + 1)));
            enemigo.setNombre(nombres[r.nextInt(5)]);
            enemigo.setPocion(r.nextInt(2));
            cuarto.agregarEnemigos1(enemigo);
        } else {
            if (cuarto.getNumEnemigos() == 2) {
                Enemigo enemigo = new Enemigo();
                enemigo.setVida(((int)(r.nextDouble() * 20 + 1)));
                enemigo.setNombre(nombres[r.nextInt(5)]);
                enemigo.setPocion(r.nextInt(2));
                Enemigo enemigo2 = new Enemigo();
                enemigo2.setVida(((int) (r.nextDouble() * 20 + 1)));
                enemigo2.setNombre(nombres[r.nextInt(5)]);
                enemigo2.setPocion(r.nextInt(2));
                cuarto.agregarEnemigos2(enemigo,enemigo2);
            }
        }
    }
}
