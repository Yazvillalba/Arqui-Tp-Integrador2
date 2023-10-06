package com.integrador2.Interfaces;

import java.util.List;

import com.integrador2.DTO.CarreraConInscriptos;
import com.integrador2.Entidades.Carrera;

public interface CarreraRepository {
    
    void agregarCarrera(Carrera carrera);

    List<CarreraConInscriptos> obtenerPorInscripto(); //ordena por cantidad de inscriptos
    List<Carrera> obtenerTodas();
    Carrera obtenerPorId(int id_carrera);
    void eliminarCarrera(Carrera carrera);
}
