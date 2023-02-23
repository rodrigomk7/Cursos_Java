/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.time.LocalDate;

/**
 *
 * @author Alumno
 */
public class Profesor extends Persona{
    private int legajo;

    public Profesor(int legajo, String dni, String nombre, String apellido, LocalDate fechaNac) {
        super(dni, nombre, apellido, fechaNac);
        this.legajo = legajo;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    @Override
    public void mostrar() {
        super.mostrar(); 
        System.out.println("Legajo: "+this.legajo);
    }
    
    
    
}
