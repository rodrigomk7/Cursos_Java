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
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public class Curso {
   private String codigo;
   private String nombre;
   private Profesor profesor;
   private List<Examen> listaExamenes=new ArrayList<>();
   private static final String ERROR_OP="La operacion no se pudo realizar";
   private static final String EXITO_OP="La operacion se realizo con exito";
   
    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Examen> getListaExamenes() {
        return listaExamenes;
    }

    public void setListaExamenes(List<Examen> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }
   
   
   public void mostrar(){
       System.out.println("Nombre: "+this.nombre+"\tCodigo: "+this.codigo);
   }
    
   public String nuevoExamen(LocalDate fecha){
       if(fecha!=null){
           Examen examen = new Examen(fecha);
           if(listaExamenes.contains(examen))
               return ERROR_OP+": Ya existe un examen para esa fecha";
           else{
           listaExamenes.add(examen);
           Collections.sort(listaExamenes,Examen::compararPorFecha);
           return EXITO_OP;
           }
           
       }else
           return ERROR_OP+": La fecha es invalida";
   }
   
   
   public void mostrarExamenes(){
       if(!listaExamenes.isEmpty()){
           for(Examen e: listaExamenes){
               e.mostrar();
               System.out.println();
           }
       }else
           System.out.println("El curso no tiene examen");
       
   }
   
   
   public void mostrarExamenes(LocalDate fecha){
   if(fecha!=null){
   Examen examen=new Examen(fecha);
   if(listaExamenes.contains(examen))
       listaExamenes.get(listaExamenes.indexOf(examen)).mostrar();
   else
       System.out.println("El curso no tiene ningun examen en esa fecha");
   }else
       System.out.println("Fecha invalida");
   
   }
   
   public Examen obtenerExamen(int posicion){
       try{
           return listaExamenes.get(posicion-1);
       }catch(NullPointerException npe){
       System.out.println("Posicion incorrecta");
       return null;
       }
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codigo);
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
        final Curso other = (Curso) obj;
        if (!this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
   
    public static int compararNombre(Curso c1,Curso c2){
        return c1.getNombre().compareTo(c2.getNombre());
    }
   
   
   
}
