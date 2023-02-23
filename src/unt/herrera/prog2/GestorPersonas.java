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
public class GestorPersonas {
    private List<Persona> listaPersonas=new ArrayList<>();
    private static final String ERROR_OP="La operacion no se pudo realizar";
     private static final String EXITO_OP="La operacion se realizo con exito";
    private static  GestorPersonas gestor;
    private GestorPersonas(){}
    public static GestorPersonas crearGestor(){
    if(gestor==null){
     gestor=new GestorPersonas();
    }
    return gestor;
    }
    
    public String nuevaPersona(int legajo, String dni, String nombre, String apellido, LocalDate fechaNac){
    if(legajo>0&&!dni.isEmpty()&&!nombre.isEmpty()&&!apellido.isEmpty()&&fechaNac!=null){
        Persona profesor=new Profesor(legajo, dni, nombre, apellido, fechaNac);
        if(listaPersonas.contains(profesor))
            return ERROR_OP;
        else{
            listaPersonas.add(profesor);
            return EXITO_OP;
        }
    }else
        return ERROR_OP;
    }
    
     public String nuevaPersona(String cx, String dni, String nombre, String apellido, LocalDate fechaNac){
    if(!cx.isEmpty()&&!dni.isEmpty()&&!nombre.isEmpty()&&!apellido.isEmpty()&&fechaNac!=null){
        Persona estudiante=new Estudiante(cx, dni, nombre, apellido, fechaNac);
        if(listaPersonas.contains(estudiante))
            return ERROR_OP;
        else{
            listaPersonas.add(estudiante);
            Collections.sort(listaPersonas,Persona::compararApellidoNombre);
            return EXITO_OP;
        }
    }else
        return ERROR_OP;
    }
     
     
     public void mostrarPersona(){
         if(!listaPersonas.isEmpty()){
         for(Persona p:listaPersonas){
             if(p instanceof Profesor){
                 Profesor profesor=(Profesor)p;
                 profesor.mostrar();
                 System.out.println();
             }
             if(p instanceof Estudiante){
                 Estudiante estudiante=(Estudiante)p;
                 estudiante.mostrar();
                 System.out.println();
             }
         }
         }else
             System.out.println("La lista de personas esta vacia");
     }


    public void mostrarProfesores(){
        if(!listaPersonas.isEmpty()){
            int c=0; 
         for(Persona p:listaPersonas){
             if(p instanceof Profesor){
                 c++;
                 Profesor profesor=(Profesor)p;
                 profesor.mostrar();
                 System.out.println();
             }
         }
         if(c==0)
             System.out.println("No hay profesores");
         
         }else
             System.out.println("La lista de personas esta vacia");
    }

    
       public void mostrarEstudiante(){
        if(!listaPersonas.isEmpty()){
            int c=0; 
         for(Persona p:listaPersonas){
              if(p instanceof Estudiante){
                  c++;
                 Estudiante estudiante=(Estudiante)p;
                 estudiante.mostrar();
                 System.out.println();
             }
         }
         if(c==0)
             System.out.println("No hay estudiantes");
         
         }else
             System.out.println("La lista de personas esta vacia");
    }
       
       
       public Persona obtenerPersona(int posicion){
       try{
           return listaPersonas.get(posicion-1);
       }catch(IndexOutOfBoundsException in){
           System.out.println("Posiciion incorrecta");
           return null;
       }
       }

       
       public Profesor obtenerProfesor(int posicion){
       try{
           Persona persona= listaPersonas.get(posicion-1);
           if(persona instanceof Profesor)
               return (Profesor)persona;
           else{
               System.out.println("La persona elegida no es un profesor");
               return null;
           }
       }catch(IndexOutOfBoundsException in){
           System.out.println("Posiciion incorrecta");
           return null;
       }
       }
       
       
       
       public Estudiante obtenerEstudiante(int posicion){
       try{
           Persona persona= listaPersonas.get(posicion-1);
           if(persona instanceof Estudiante)
               return (Estudiante)persona;
           else{
               System.out.println("La persona elegida no es un estudiante");
               return null;
           }
       }catch(IndexOutOfBoundsException in){
           System.out.println("Posiciion incorrecta");
           return null;
       }
       }
}
