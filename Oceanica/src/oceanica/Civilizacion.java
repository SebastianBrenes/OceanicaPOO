/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oceanica;

import java.util.ArrayList;

/**
 *
 * @author Portatil_HP
 */
public class Civilizacion {
    private String nombre;
    private ArrayList<Luchador> luchadores;
    
    // Constructor
    public Civilizacion(String nombre) {
        this.nombre = nombre;
        this.luchadores = new ArrayList<>();
    }
    
    
    public void agregarLuchador(Luchador luchador) {
        this.luchadores.add(luchador);
    }

    // Métodos getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Luchador> getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(ArrayList<Luchador> luchadores) {
        this.luchadores = luchadores;
    }
}

