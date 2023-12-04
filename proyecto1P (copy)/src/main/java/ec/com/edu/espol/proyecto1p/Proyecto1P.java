/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.com.edu.espol.proyecto1p;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.useDelimiter("\n");
        Juego j = new Juego();
        j.agregarJugador("Maquina");
        j.agregarJugador("Jugador1");
        int contador = 0;
        int i = 0;
        while (!(estaVacia(j.getJugadores())) && (contador < j.getJugadores().get(i).getMano().size())){
            if (i > j.getJugadores().size())
                i = 0;
            System.out.printf(j.getJugadores().get(i).getNombre() + ": " + "Mano ->");
            j.getJugadores().get(i).imprimirMano();
            System.out.printf("Linea de juego ->");
            j.mostrarLinea();
            int k = 0;
            if (j.getJugadores().get(i).getNombre().contains("Maquina")){
                if (j.agregarFichaLinea(Utilitaria.simularJuego(j.getJugadores().get(i).getMano(), k, j), j.getJugadores().get(i))){
                    System.out.println("Movimiento valido");
                    k++;
                    contador = 0;
                } else {
                    System.out.println("Ficha tenia " + Utilitaria.simularJuego(j.getJugadores().get(i).getMano(), k, j).toString() + ". No puede jugar esa ficha, intentelo de nuevo" );
                    contador++;
                    k++;
                }
            } else {
                System.out.printf("Índice de ficha para jugar (0 es el primero): ");
                int indice = sc.nextInt();
                if (j.agregarFichaLinea(j.getJugadores().get(i).getMano().get(indice), j.getJugadores().get(i))){
                    System.out.println("Movimiento valido");
                    contador = 0;
                } else {
                    System.out.println("Ficha tenia " + j.getJugadores().get(i).getMano().get(indice).toString() + ". No puede jugar esa ficha, intentelo de nuevo" );
                    contador++; 
                }
            }
            if (contador == j.getJugadores().get(i).getMano().size()){
                System.out.println(j.getJugadores().get(i).getNombre() + ": Has perdido, gracias por jugar.");
            }
            i++;
            System.out.println("");
        }
        if (estaVacia(j.getJugadores())){
            for (Jugador jugador: j.getJugadores()){
                if (jugador.getMano().isEmpty()){
                    System.out.println(jugador.getNombre() + ", ha ganado, felicitaciones!");
                }
            }
        }
    }
}
