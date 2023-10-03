package com.integrador2;

import java.io.IOException;
import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Repositories.CarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        CSVLoader loader = new CSVLoader();

        try {
            // loader.loadEstudiantes("estudiante.csv");
            // loader.loadCarrera("carrera.csv");

            // loader.insertarEstudiante();
            // loader.insertarCarrera();
            // CarreraRepositoryImpl eImpl = new CarreraRepositoryImpl();
            // List<Carrera> carreras = eImpl.obtenerTodas();
            // for (Carrera carrera : carreras) {
            //     System.out.println(carrera.getNombre()+ " "+carrera.getId());
            // }
            
            loader.loadEstudianteCarrera("estudianteCarrera.csv");
            loader.insertarEstudianteCarrera();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("NO SE CARRRGOOOOOOOO");
        }

        // Estudiante est1 = new Estudiante(43864400,"yazmin" , "villalba", 22,
        // "femenino", "Olavarria", 27500);
        // Estudiante est2 = new Estudiante(43864700,"marlene" , "carli", 100,
        // "femenino", "Olavarria",25450);
        // Estudiante est3 = new Estudiante(27150, 34942135, "Maria Edith",
        // "Esteberena", 44,"femenino", "Tandil");
        // Estudiante est4 = new Estudiante(3495513,"Juan Carlos" , "Ch...",
        // 40,"masculino", "Tandil", 25825);

        // EstudianteRepositoryImpl eImpl= new EstudianteRepositoryImpl();

        // eImpl.agregarEstudiante(est1);
        // eImpl.agregarEstudiante(est2);
        // eImpl.agregarEstudiante(est4);
        // System.out.println("obtener todos");
        // System.out.println(" ");
        // List<Estudiante> estudiantes = eImpl.obtenerTodos();

        // for (Estudiante estudiante : estudiantes) {
        // System.out.println(estudiante.getNombre());
        // }
        // System.out.println(" ");
        // System.out.println("uno por libreta");

        // Estudiante estu1 = eImpl.obtenerUnoPorLibreta(10904);
        // System.out.println(estu1.getDni() + " " + estu1.getNombre() + " "+
        // estu1.getApellido());
        // System.out.println(" ");
        // System.out.println("Todos los de genero: M");
        // List<Estudiante> estudiantes3 = eImpl.obtenerTodosPorGenero("masculino");
        // for (Estudiante estudiante : estudiantes3) {
        // System.out.println(estudiante.getNombre() + " "+ estudiante.getApellido());
        // }
        // Estudiante est3 = eImpl.obtenerUnoPorLibreta(27150);
        // eImpl.eliminarEstudiante(est3);
    }
}