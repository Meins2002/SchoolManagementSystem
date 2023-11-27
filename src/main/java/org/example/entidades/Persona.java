package org.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor



public class Persona{

    private int id;
    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;



    @Override
    public String toString() {
        return "ESTUDIANTE: " + '\n' +
                "  ID:" + id + '\n' +
                "  Nombre:    " + nombre + '\'' +
                "  apellido:  " + apellido + '\'' +
                "  Fecha De Nacimiento: " + fechaDeNacimiento  ;
    }
}
