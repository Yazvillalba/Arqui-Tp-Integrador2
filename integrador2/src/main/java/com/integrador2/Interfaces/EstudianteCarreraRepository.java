package com.integrador2.Interfaces;

import com.integrador2.DTO.CarreraDTO;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;

public interface EstudianteCarreraRepository {

    void matricularEstudiante(Estudiante estudiante, CarreraDTO carrera, int anioInscripcion, int graduacion, int antiguedad);
}
