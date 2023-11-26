package org.example.entidades;

import lombok.AllArgsConstructor;
import org.example.servicios.EstudianteNoInscritoEnCursoException;
import org.example.servicios.EstudianteYaInscritoException;
import org.example.servicios.ServiciosAcademicosI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor

public class GestorAcademico implements ServiciosAcademicosI {

        private List<Estudiante> estudiantes;
        private List<Curso> cursos;
        private Map<Curso, List<Estudiante>> estudiantesPorCurso;

        @Override
        public void matricularEstudiante(Estudiante estudiante) {
                if (!estudiantes.contains(estudiante)) {
                           estudiantes.add(estudiante);
                }
        }
        @Override
        public void agregarCurso(Curso curso) {
                if (!cursos.contains(curso)) {
                        cursos.add(curso);
                }
        }

        @Override
        public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso)
                throws EstudianteYaInscritoException {

                if (!estudiantes.contains(estudiante)) {
                        throw new IllegalArgumentException("El estudiante no está matriculado.");
                }

                if (!cursos.stream().anyMatch(curso -> curso.getId() == idCurso)) {
                        throw new IllegalArgumentException("ID de curso no válido.");
                }

                if (estudiantesPorCurso.containsKey(idCurso) && estudiantesPorCurso.get(idCurso).contains(estudiante.getId())) {
                        throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
                }

                //estudiantesPorCurso.computeIfAbsent(, key -> new ArrayList<>()).add(estudiante.getId());
        }


        @Override
        public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {

                if (!estudiantes.stream().anyMatch(estudiante -> estudiante.getId() == idEstudiante)) {
                        throw new IllegalArgumentException("ID de estudiante no válido.");
                }

                if (!cursos.stream().anyMatch(curso -> curso.getId() == idCurso)) {
                        throw new IllegalArgumentException("ID de curso no válido.");
                }

                if (!estudiantesPorCurso.containsKey(idCurso) || !estudiantesPorCurso.get(idCurso).contains(idEstudiante)) {
                        throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
                }

                estudiantesPorCurso.get(idCurso).remove(Integer.valueOf(idEstudiante));
        }

}

