package org.example.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor

public class Curso {

    private int idCurso;
    private String nombreCurso;
    private String descripcion;
    private int numeroCreditos;
    private String version;

    @Override
    public String toString() {
        return "CURSO: " + '\n' +
                "  ID:  " + idCurso + '\n' +
                "  Nombre:  " + nombreCurso + '\'' +'\n' +
                "  Descripcion:  " + descripcion + '\'' +'\n' +
                "  NumeroCreditos:  " + numeroCreditos + '\n' +
                "  Version:  " + version + '\'' + '\n' ;
    }
}


