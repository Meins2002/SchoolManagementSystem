package org.example.entidades;

import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

public class Estudiante extends Persona {

    @Getter
    @Setter

    private int estado;
    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, int estado) {
        super(id, nombre, apellido, fechaDeNacimiento);

        switch (estado) {
            case 1:
                this.setEstado(estado);
                System.out.println("Matriculado");
                break;
            case 2:
                this.setEstado(estado);
                System.out.println("Inactivo");
                break;
            case 3:
                this.setEstado(estado);
                System.out.println("Graduado");
                break;
            default:
                System.out.println("Esta opción no existe");
        }


    }
}
