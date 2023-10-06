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

            // Carrera carreraX = carreraRepo.obtenerPorId(13);

            // List<Estudiante> estudiantes =
            // estudianteRepo.obtenerEstudiantePorCarreraYCiudad(carreraX, "Lyamino");

            // for (Estudiante estudiante : estudiantes) {
            // System.out.println(estudiante);
            // }
            // Estudiante est1 = new Estudiante(43864400, "yazmin", "villalba", 22,
            // "femenino", "Olavarria", 27500);
            // estudianteRepo.agregarEstudiante(est1);
            // System.out.println("obtener todos");
            // System.out.println(" ");
            // List<Estudiante> TodosEstudiantes = estudianteRepo.obtenerTodos();

            // for (Estudiante estudiante : TodosEstudiantes) {
            // System.out.println(estudiante.getNombre());
            // }
            // System.out.println(" ");
            // System.out.println("uno por libreta");

            // Estudiante estu1 = estudianteRepo.obtenerUnoPorLibreta(27500);
            // System.out.println(estu1.getDni() + " " + estu1.getNombre() + " " +
            // estu1.getApellido());
            // System.out.println(" ");
            // System.out.println("Todos los de genero: M");
            // List<Estudiante> EstudiantesMasc =
            // estudianteRepo.obtenerTodosPorGenero("masculino");
            // for (Estudiante estudiante : EstudiantesMasc) {
            // System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
            // }
            // System.out.println(" ");
            // System.out.println("Todos los de genero: F");
            // List<Estudiante> EstudiantesFem =
            // estudianteRepo.obtenerTodosPorGenero("femenino");
            // for (Estudiante estudiante : EstudiantesFem) {
            // System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
            // }
            // System.out.println(" ");
            // Estudiante estudporID = estudianteRepo.obtenerPorId(23322529);
            // System.out.println(estudporID.getDni() + " " + estudporID.getNombre() + " " +
            // estudporID.getApellido());

            // Estudiante est3 = estudianteRepo.obtenerUnoPorLibreta(27500);
            // estudianteRepo.eliminarEstudiante(est3);
            // System.out.println("Estudiantes Por Carrera y Ciudad");
            // List<Estudiante> est = estudianteRepo.obtenerEstudiantePorCarreraYCiudad(carrera, "Rauch");
            // for (Estudiante estudiante : est) {
            //     System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " ");
            // }
            // Carrera car1 = new Carrera("TUDAI", 2);
            // carreraRepo.agregarCarrera(car1);
            // System.out.println("Todas las carreras:");
            // List<Carrera> carreras = carreraRepo.obtenerTodas();
            //  for (Carrera carrera : carreras) {
            //     System.out.println(carrera.getNombre() + " " + carrera.getId());
            // }
            // System.out.println(" ");
            // System.out.println("Carrera por ID");
            //Carrera carrera = carreraRepo.obtenerPorId(22);
            // System.out.println(carrera.getNombre());
            // System.out.println(" ");
            // List<CarreraConInscriptos> carreraConInscriptos = carreraRepo.obtenerPorInscripto();
            // for (CarreraConInscriptos carrerass : carreraConInscriptos) {
            //     System.out.println(carrerass);
            // }
            //carreraRepo.eliminarCarrera(carrera);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en main");
        }

    }
}
