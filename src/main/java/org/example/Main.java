package org.example;
import java.util.*;

import org.example.entidades.Curso;
import org.example.entidades.Estudiante;
import org.example.entidades.GestorAcademico;
import org.example.servicios.EstudianteNoInscritoEnCursoException;
import org.example.servicios.EstudianteYaInscritoException;

public class Main {
    public static void main(String[] args) throws EstudianteYaInscritoException, EstudianteNoInscritoEnCursoException {

        List<Estudiante> estudiantes = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        Map<Curso, List<Estudiante>> estudiantesPorCurso = new HashMap<>();

        Scanner scanner = new  Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("     Información del Estudiante      ");
        System.out.println("*************************************");
        System.out.print(" 1. ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print(" 2. Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print(" 3. Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print(" 4. Fecha de nacimiento: ");
        String fechaDeNacimiento = scanner.nextLine();
        System.out.println(" 5. Estado: ");
        System.out.println("  ( 1 = Matriculado" + " | " + " 2 = Inactivo" + " | " +
                " | " + " 3 = Graduado )");
        int estado = scanner.nextInt();



        System.out.println("*************************************");
        System.out.println("     Información del Curso           ");
        System.out.println("*************************************");
        System.out.print(" 1. ID: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();
        System.out.print(" 2. Nombre: ");
        String nombreCurso = scanner.nextLine();
        System.out.print(" 3. Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print(" 4. Numero de creditos: ");
        int numerosCreditos = scanner.nextInt();
        scanner.nextLine();
        System.out.print(" 5. Versión: ");
        String version = scanner.nextLine();

        GestorAcademico gestorAcademico = new GestorAcademico(estudiantes, cursos, new HashMap<>());
        Estudiante estudiante = new Estudiante(id, nombre, apellido, fechaDeNacimiento, estado);
        Curso curso = new Curso(idCurso, nombreCurso,descripcion,numerosCreditos,version);


        gestorAcademico.matricularEstudiante(estudiante);
        gestorAcademico.agregarCurso(curso);

        while (true) {

            System.out.println(" 1. Incribir estudiante ");
            System.out.println(" 2. Desinscribir estudiante");
            System.out.println(" Seleccione opcion: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 1:
                    try {
                        gestorAcademico.inscribirEstudianteCurso(estudiante, curso.getIdCurso());
                    }catch (EstudianteYaInscritoException e){
                        System.out.println("Error "  + e.getMessage());
                    }
                    scanner.close();
                    System.exit(0);
                    break;
                case 2:
                    try {
                        gestorAcademico.desinscribirEstudianteCurso(estudiante.getId(), curso.getIdCurso());
                    }catch (EstudianteNoInscritoEnCursoException e){
                        System.out.println("Error " + e.getMessage());
                    }
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida");
            }
        }


    }
}