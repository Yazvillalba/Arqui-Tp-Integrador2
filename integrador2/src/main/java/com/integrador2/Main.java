package com.integrador2;

import java.util.List;

import com.integrador2.DTO.CarreraConInscriptos;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;
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

            Carrera carreraX = carreraRepo.obtenerPorId(13);

            List<Estudiante> estudiantes = estudianteRepo.obtenerEstudiantePorCarreraYCiudad(carreraX, "Lyamino");
            
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }   
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en main");
        }
    }
}
