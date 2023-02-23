/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorCursos {
    private List<Curso> listaCursos=new ArrayList<>();
    private static final String ERROR_OP="La operacion no se pudo realizar";
    private static final String EXITO_OP="La operacion se realizo con exito";
    private static GestorCursos gestor;
    private GestorCursos(){}
    public static GestorCursos crearGestor(){
        if(gestor==null)
            gestor=new GestorCursos();
        return gestor;
    }
    
    
    public String nuevoCurso(String codigo, String nombre, Profesor profesor){
        if(!codigo.isEmpty()&&!nombre.isEmpty()&&profesor!=null){
            Curso curso=new Curso(codigo, nombre, profesor);
            if(listaCursos.contains(curso))
                return ERROR_OP;
            else{
                listaCursos.add(curso);
                Collections.sort(listaCursos,Curso::compararNombre);
                return EXITO_OP;          
            }
        }else
            return ERROR_OP;
        
    }
    
    
    public Curso obtenerCurso(int posicion){
        try{
            return listaCursos.get(posicion-1);
        }catch(IndexOutOfBoundsException in){
            System.out.println("Posicion incorrecta");
            return null;
        }
        
    }
    
    public void mostrarCursos(){
    if(!listaCursos.isEmpty()){
        for(Curso c:listaCursos){
            c.mostrar();
            System.out.println();
        }
    }else
        System.out.println("La lista de cursos esta vacia");
    }
    
    
}
