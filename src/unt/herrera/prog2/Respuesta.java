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
public class Respuesta implements Comparable<Respuesta>{
    private Boolean respuesta;
    private Pregunta pregunta;

    public Respuesta(Boolean respuesta, Pregunta pregunta) {
        this.respuesta = respuesta;
        this.pregunta = pregunta;
    }


    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.pregunta);
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
        final Respuesta other = (Respuesta) obj;
        if (this.pregunta.equals(other.pregunta)==false) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Respuesta o) {
    
    return this.pregunta.compareTo(o.getPregunta());
    }
    
    
    public void mostrar(){
        this.pregunta.mostrar();
        String resp;
        if(this.respuesta)
            resp="Verdadero";
        else
            resp="Falso";
        System.out.println("Respuesta: "+resp);
    }
    
    
    
    
    
}
