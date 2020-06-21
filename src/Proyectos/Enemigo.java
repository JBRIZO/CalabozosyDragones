package Proyectos;

import java.util.*;
public class Enemigo
{
    Random r = new Random();
   private int vida;
   private String nombre;
   private int pocion;
    private boolean vivo = true;

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }


    public int getPocion() {
        return pocion;
    }

    public void setPocion(int pocion) {
        this.pocion = pocion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void atacar(Heroe heroe)
    {
        if (vida > 0)
        {
            Random r = new Random();
            int atk = (int)(r.nextDouble()*100+100);
            heroe.setVida(getVida()-atk);
            System.out.println(nombre + " te ataca y ejerce " + atk + " puntos de daño!!");
        }

    }

}




