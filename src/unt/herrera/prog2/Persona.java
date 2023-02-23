/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Alumno
 */
public abstract class   Persona {
    
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

    public Persona(String dni, String nombre, String apellido, LocalDate fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.dni);
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
    
    
    public void mostrar(){
        String formato="dd/MM/yyyy";
        System.out.println("Apellido:"+this.apellido+"\tNombre: "+this.nombre+"\nD.N.I: "+this.dni+"Fecha de nacimiento: "+this.fechaNac.format(DateTimeFormatter.ofPattern(formato)));
    }
    
    public static int compararApellidoNombre(Persona p1,Persona p2){
        if(p1.apellido.compareTo(p2.getApellido())!=0)
            return  p1.apellido.compareTo(p2.getApellido());
        else
            return p1.getNombre().compareTo(p2.getNombre());
    }


}
