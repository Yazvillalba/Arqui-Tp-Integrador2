package com.integrador2.Interfaces;

import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;

public interface EstudianteRepository {
    
    void agregarEstudiante(Estudiante estudiante);
    
    List<Estudiante> obtenerTodos();
    
    Estudiante obtenerUnoPorLibreta(int nroLibreta);

    List<Estudiante> obtenerTodosPorGenero(String genero);

    void eliminarEstudiante(Estudiante estudiante);
    Estudiante obtenerPorId(int id_estudiante);
}
