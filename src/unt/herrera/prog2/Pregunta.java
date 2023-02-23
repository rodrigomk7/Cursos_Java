/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class Pregunta implements Comparable<Pregunta>{
    private int orden;
    private String texto;
    private Examen examen;

    public Pregunta(int orden, String texto, Examen examen) {
        this.orden = orden;
        this.texto = texto;
        this.examen = examen;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.orden;
        hash = 71 * hash + Objects.hashCode(this.texto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregunta other = (Pregunta) obj;
        
        if (this.orden != other.orden) {
            if (this.texto.equals(other.texto)==false) 
                return false;
            else
                return true;
        }
        return true;
        
    }

    @Override
    public int compareTo(Pregunta o) {
     return this.orden-o.getOrden();
    }
    
    
    public void mostrar(){
    System.out.println("Pregunta n° "+this.orden+":\n"+this.texto);
    }
    
    
}
