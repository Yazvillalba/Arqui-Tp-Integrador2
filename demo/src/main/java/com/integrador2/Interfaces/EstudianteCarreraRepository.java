package com.integrador2.Interfaces;

import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;

public interface EstudianteCarreraRepository {
    
    void matricularEstudiante(Estudiante estudiante, Carrera carrera);
    List<Estudiante> obtieneEstudiantesCarrera(Carrera carrera);

}
