/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.com.edu.espol.proyecto1p;

import java.util.ArrayList;

/**
 *
 * @author xavih830
 */
public class Proyecto1P {
    public static boolean estaVacia(ArrayList<Jugador> jugadores){
        for (Jugador j: jugadores){
            if (j.getMano().isEmpty())
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Juego j = new Juego();
        j.agregarJugador("Maquina");
        j.agregarJugador("Jugador1");
        int contador = 0;
        int i = 0;
        while (estaVacia(j.getJugadores()) && (contador < j.getJugadores().get(i).getMano().size())){
            if (i > j.getJugadores().size())
                i = 0;
            System.out.printf(j.getJugadores().get(i).getNombre() + ": " + "Mano ->");
            j.getJugadores().get(i).imprimirMano();
            j.mostrarLinea();
            if ()
            j.agregarFichaLinea(j.getJugadores().get(i).getFicha(), );
        }
    }
}
