/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.edu.espol.proyecto1p;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author xavih830
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        this.lineaJuego = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }
    
    public void agregarJugador(String nombre){
        Jugador j = new Jugador(nombre, Utilitaria.crearManoJugador());
        this.jugadores.add(j);
    }
    
    public int obtenerValorInicioLinea(){
        return ((this.lineaJuego).get(0)).getLado1();
    }
    
    public int obtenerValorFinLinea(){
        return ((this.lineaJuego).get((this.lineaJuego).size()-1)).getLado2();
    }
    
    public void mostrarLinea(){
        for (int i=0; i<this.lineaJuego.size(); i++){
            if (i != this.lineaJuego.size()-1){
                System.out.printf(this.lineaJuego.get(i).toString()+" - ");
            }
            else{
                System.out.println(this.lineaJuego.get(i).toString());
            }
        }
    }

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.useDelimiter("\n");
        if(f instanceof FichaComodin){
            FichaComodin o = (FichaComodin)f;
            if (this.lineaJuego.size() > 0){
                System.out.printf("Escriba la posición en la que quiere agregar su ficha(Inicio/Fin): ");
                String prompt = sc.next();
                if (prompt.equals("Inicio")){
                    System.out.printf("Actualice el valor de lado2 de su ficha: ");
                    int lado2 = sc.nextInt();
                    o.setLado2(lado2);
                    this.lineaJuego.add(0, o);
                    j.getMano().remove(j.getMano().size() - 1);
                    return true;
                } else if (prompt.equals("Fin")){
                    System.out.printf("Actualice el valor de lado1 de su ficha: ");
                    int lado1 = sc.nextInt();
                    o.setLado1(lado1);
                    this.lineaJuego.add( o);
                    j.getMano().remove(j.getMano().size() - 1);
                    return true;
                }
            } else {
                System.out.printf("Actualice el valor de lado1 de su ficha:");
                int lado1 = sc.nextInt();
                System.out.printf("Actualice el valor de lado2 de su ficha");
                int lado2 = sc.nextInt();
                o.setLado1(lado1);
                o.setLado2(lado2);
                this.lineaJuego.add(o);
                j.getMano().remove(j.getMano().size() - 1);
                return true;        
            } 
        }else {
            if (this.lineaJuego.size() > 0){
                if (f.getLado1() == this.obtenerValorFinLinea()){
                    this.lineaJuego.add( f);
                    j.getMano().remove(f);
                    return true;
                } else if (f.getLado2() == this.obtenerValorInicioLinea()){
                    this.lineaJuego.add(0, f);
                    j.getMano().remove(f);
                    return true;
                } else
                    return false;
            } else{
                this.lineaJuego.add(f);
                return true;
            }
        }
        return false;
    }
}
