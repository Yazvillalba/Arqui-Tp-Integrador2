package com.integrador2.Interfaces;

import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;

public interface EstudianteCarreraRepository {
   

    void matricularEstudiante(Estudiante estudiante, Carrera carrera, int anioInscripcion, int graduacion, int antiguedad);
    List<Estudiante> obtieneEstudiantesCarrera(Carrera carrera, String ciudad);
}
