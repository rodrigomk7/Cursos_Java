/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        GestorCursos gcursos=GestorCursos.crearGestor();
        GestorPersonas gpersonas=GestorPersonas.crearGestor();
        
       //
       gpersonas.nuevaPersona(123,"34567","Luis","Nieto", LocalDate.of(1950,7,14));//4 prof
       gpersonas.nuevaPersona(123,"34567","Lucio","Perez", LocalDate.of(1930,7,14));//
       gpersonas.nuevaPersona(456,"33367","Jose","Abdala", LocalDate.of(1900,7,14));//1 prof
       gpersonas.nuevaPersona("151413","36789","Pedro","Abdala", LocalDate.of(1996,7,14));//2 al
       gpersonas.nuevaPersona("151413","34567","Juan","Abdala", LocalDate.of(1998,7,14));//
       gpersonas.nuevaPersona("141290","56789","Rick","Grimes", LocalDate.of(1999,7,14));//3 al
       
       gcursos.nuevoCurso("345","Prog",gpersonas.obtenerProfesor(4));
       gcursos.nuevoCurso("345","Prog",gpersonas.obtenerProfesor(4));//
       gcursos.nuevoCurso("1232","Cir",gpersonas.obtenerProfesor(1));
        
       
       gcursos.obtenerCurso(1).nuevoExamen(LocalDate.of(2016,7,5));
       gcursos.obtenerCurso(1).nuevoExamen(LocalDate.of(2016,7,5));//
       gcursos.obtenerCurso(2).nuevoExamen(LocalDate.of(2016,9,6));
       
      gcursos.obtenerCurso(1).obtenerExamen(1).nuevaPregunta(1,"Los perros vuelan?");
      gcursos.obtenerCurso(1).obtenerExamen(1).nuevaPregunta(2,"Los perros caminan?");
      gcursos.obtenerCurso(1).obtenerExamen(1).nuevaPregunta(3,"Los gatos nadan?");
      
      gcursos.obtenerCurso(2).obtenerExamen(1).nuevaPregunta(1,"En el desierto hace calor?");
      gcursos.obtenerCurso(2).obtenerExamen(1).nuevaPregunta(2,"En el desierto hace calor?");
      
    gpersonas.obtenerEstudiante(2).responderPregunta(gcursos.obtenerCurso(1).obtenerExamen(1).obtenerPregunta(1), true);
     gpersonas.obtenerEstudiante(2).responderPregunta(gcursos.obtenerCurso(1).obtenerExamen(1).obtenerPregunta(2), false);
     gpersonas.obtenerEstudiante(2).responderPregunta(gcursos.obtenerCurso(1).obtenerExamen(1).obtenerPregunta(3), false);
          
     
     gpersonas.obtenerEstudiante(2).mostrarRespuestas(gcursos.obtenerCurso(1).obtenerExamen(1));
//   gpersonas.mostrarPersona();
    }
    
}
