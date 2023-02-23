/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class Examen {
    private LocalDate fecha;
    private List<Pregunta> listaPreguntas= new ArrayList<>();
    private static final String ERROR_OP="La operacion no se pudo realizar";
    private static final String EXITO_OP="La operacion se realizo con exito";
    private static final String EXAMEN_VACIO="El examen no tiene preguntas";
    public Examen(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    
    public String nuevaPregunta(int orden , String texto){
        if(orden>0&&!texto.isEmpty()){
            Pregunta pregunta=new Pregunta(orden, texto, this);
            if(listaPreguntas.contains(pregunta))
                return ERROR_OP;
            else{
                listaPreguntas.add(pregunta);
                Collections.sort(listaPreguntas);
                return EXITO_OP;
            }
        }else
        return ERROR_OP;
    }
    
    public Pregunta obtenerPregunta(int orden){
        if(!listaPreguntas.isEmpty()){
        try{
            Pregunta pregunta=listaPreguntas.get(orden-1);
            return  pregunta;
        }catch(IndexOutOfBoundsException in){
            System.out.println("El orden ingresado es incorrecto");
            return null;
        }
        }else{
             System.out.println(EXAMEN_VACIO);
            return null;
        }
    }
            
        
    public void mostrar(){
        System.out.println("Fecha del examen: "+this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"\t\tLista de preguntas:");
      System.out.println("---------------------------------------------------");
        if(!listaPreguntas.isEmpty()){
            for(Pregunta p:listaPreguntas){
                p.mostrar();
                System.out.println();
            }
            
        }else{System.out.println(EXAMEN_VACIO);}
    }        

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.fecha);
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
        final Examen other = (Examen) obj;
        if (this.fecha.compareTo(other.fecha)!=0) {
            return false;
        }
        return true;
    }
    
    public static int compararPorFecha(Examen e1,Examen e2){
    return e1.getFecha().compareTo(e2.getFecha());
    }
}
