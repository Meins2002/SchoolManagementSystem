package org.example.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor

public class curso {

    private int id;
    private String nombre;
    private String descripcion;
    private int numeroCreditos;
    private String version;

    @Override
    public String toString() {
        return "CURSO: " + '\n' +
                "  ID:  " + id + '\n' +
                "  Nombre:  " + nombre + '\'' +'\n' +
                "  Descripcion:  " + descripcion + '\'' +'\n' +
                "  NumeroCreditos:  " + numeroCreditos + '\n' +
                "  Version:  " + version + '\'' + '\n' ;
    }
}


