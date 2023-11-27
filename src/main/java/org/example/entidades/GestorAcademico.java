package org.example.entidades;

import lombok.Getter;
import lombok.Setter;
import org.example.servicios.EstudianteNoInscritoEnCursoException;
import org.example.servicios.EstudianteYaInscritoException;
import org.example.servicios.ServiciosAcademicosI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Getter
@Setter

public class GestorAcademico implements ServiciosAcademicosI {

        private List<Estudiante> estudiantes;
        private List<Curso> cursos;
        private Map<Integer, ArrayList<Object>> estudiantesPorCurso;

        public GestorAcademico(List<Estudiante> estudiantes, List<Curso> cursos, Map<Integer, ArrayList<Object>> estudiantesPorCurso) {
                this.estudiantes = estudiantes;
                this.cursos = cursos;
                this.estudiantesPorCurso = estudiantesPorCurso;
        }

        @Override
        public void matricularEstudiante(Estudiante estudiante) {
                if (!estudiantes.contains(estudiante)) {
                        estudiantes.add(estudiante);
                        System.out.println("Estudiante matriculado exitosamente.");
                } else {
                        System.out.println("El estudiante ya está matriculado.");
                }
        }

        public void agregarCurso(Curso curso) {
                if (!cursos.contains(curso)) {
                        cursos.add(curso);
                        estudiantesPorCurso.put(curso.getIdCurso(), new ArrayList<Object>());
                        System.out.println("Curso agregado exitosamente.");
                } else {
                        System.out.println("El curso ya está creado.");
                }
        }

        @Override
        public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso)
                throws EstudianteYaInscritoException {

                if (!estudiantes.contains(estudiante)) {
                        throw new EstudianteYaInscritoException("El estudiante no está matriculado.");
                }

                if (!cursos.stream().anyMatch(curso -> curso.getIdCurso() == idCurso)) {

                        throw new EstudianteYaInscritoException("El curso no existe.");
                }

                if (estudiantesPorCurso.get(idCurso).contains(estudiante)) {
                        throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
                }

                estudiantesPorCurso.get(idCurso).add(estudiante);
                System.out.println("Estudiante inscrito en el curso exitosamente.");
        }
        @Override
        public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
                Estudiante estudiante = estudiantes.stream().filter(e -> e.getId() == idEstudiante).findFirst().orElse(null);

                if (estudiante == null) {
                        throw new EstudianteNoInscritoEnCursoException("El estudiante no está matriculado.");
                }

                if (!cursos.stream().anyMatch(curso -> curso.getIdCurso() == idCurso)) {
                        throw new EstudianteNoInscritoEnCursoException("El curso no existe.");
                }

                if (!estudiantesPorCurso.get(idCurso).contains(estudiante)) {
                        throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
                }
                estudiantesPorCurso.get(idCurso).remove(estudiante);
                System.out.println("Estudiante desinscrito del curso exitosamente.");
        }

}

