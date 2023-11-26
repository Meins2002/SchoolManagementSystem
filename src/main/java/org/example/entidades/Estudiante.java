package org.example.entidades;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Estudiante {

    private int id;
    private String nombre;
    private String apellido;
    private Date fechaDeNacimiento;
    private String estado;

    @Override
    public String toString() {
        return "ESTUDIANTE: " + '\n' +
                "  ID:" + id + '\n' +
                "  Nombre:    " + nombre + '\'' +
                "  apellido:  " + apellido + '\'' +
                "  Fecha De Nacimiento: " + fechaDeNacimiento +
                "  Estado: " + estado + '\'' ;
    }
}
