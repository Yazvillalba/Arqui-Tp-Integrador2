package com.integrador2.Interfaces;

import java.util.List;

import com.integrador2.DTO.CarreraConInscriptosDTO;
import com.integrador2.DTO.ReporteDTO;
import com.integrador2.Entidades.Carrera;

public interface CarreraRepository {
    
    void agregarCarrera(Carrera carrera);

    Carrera obtenerPorId(int idCarrera);

    List<Carrera> obtenerTodas();
    
    List<CarreraConInscriptosDTO> obtenerPorCantInscriptos(); //ordena por cantidad de inscriptos

    void eliminarCarrera(Carrera carrera);

    List<ReporteDTO> generarReporteCarreras();
}
