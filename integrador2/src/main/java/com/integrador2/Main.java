package com.integrador2;

import java.util.List;

import com.integrador2.DTO.CarreraConInscriptosDTO;
import com.integrador2.DTO.CarreraDTO;
import com.integrador2.DTO.ReporteDTO;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;
import com.integrador2.Factory.FactoryRepositoryImpl;
import com.integrador2.Interfaces.CarreraRepository;
import com.integrador2.Repositories.CarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteCarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        CSVLoader loader = new CSVLoader();

        try {
            // loader.loadEstudiantes("estudiantes.csv");
            // loader.loadCarrera("carreras.csv");

            // loader.loadEstudianteCarrera("estudianteCarrera.csv");

            EstudianteRepositoryImpl estudianteRepo = new EstudianteRepositoryImpl();
            CarreraRepositoryImpl carreraRepo = new CarreraRepositoryImpl();

            CarreraDTO carrera = carreraRepo.obtenerPorId(1);
            System.out.println(carrera.getCabeceraTabla());
            System.out.println(carrera);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en main");
        }

    }
}
