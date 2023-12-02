/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.edu.espol.proyecto1p;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author xavih830
 */
public class Utilitaria {  
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> lista = new ArrayList<>();
        Random r = new Random();
        for (int i=0; i<5; i++){
            int a = r.nextInt(7) + 1;
            int b = r.nextInt(7) + 1;
            Ficha f = new Ficha(a, b);
            lista.add(f);
        }
        return lista;
    }
}
