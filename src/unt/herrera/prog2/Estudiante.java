/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class Estudiante extends Persona{
    private String cx;
    private List<Respuesta> listaRespuestas=new ArrayList<>();

    public Estudiante(String cx, String dni, String nombre, String apellido, LocalDate fechaNac) {
        super(dni, nombre, apellido, fechaNac);
        this.cx = cx;
    }

   
    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("CX: "+this.cx);
    }
    
    
    public void  responderPregunta(Pregunta pregunta , boolean respuesta){
        if(pregunta!=null){
            Respuesta resp =new Respuesta(respuesta, pregunta);
            int c=0;
            if(!listaRespuestas.contains(resp))
                listaRespuestas.add(resp);
            else
                System.out.println("Ya hay una respuesta para esta pregunta");
            
        }else{System.out.println("");}
    }
 
    public void mostrarRespuestas(Examen examen){
        if(!listaRespuestas.isEmpty()){
        Collections.sort(listaRespuestas);
        
        for(Pregunta p:examen.getListaPreguntas()){
           for(Respuesta re:listaRespuestas){ 
               if(re.getPregunta().equals(p)){
                   re.mostrar();
                   System.out.println();
               }
           }
        }
        }else
            System.out.println("El estudiante no ha respondido a ninguna pregunta");
        
        
    }
    
    
    
    
}   