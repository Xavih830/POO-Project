/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.edu.espol.proyecto1p;

import java.util.ArrayList;

/**
 *
 * @author xavih830
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador() {
        this.mano = new ArrayList<>();
    }
    
    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Ficha> getMano() {
        return this.mano;
    }
    
    public Ficha getFicha(int i){
        if (i < this.mano.size())
            return this.mano.get(i);
        else
            return null;
    }
    
    public void removerFicha(Ficha f){
        this.mano.remove(f);
    }
    
    public void imprimirMano(){
        for (int i = 0; i < this.mano.size(); i++){
            if (i != this.mano.size()-1)
                System.out.printf(this.mano.get(i).toString()+"-");
            else
                System.out.println(this.mano.get(i).toString());
        }
    }
}
