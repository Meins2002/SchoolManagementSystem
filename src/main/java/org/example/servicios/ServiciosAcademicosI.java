package org.example.servicios;

import org.example.entidades.Curso;
import org.example.entidades.Estudiante;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante);

    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso)throws EstudianteNoInscritoEnCursoException;
}
