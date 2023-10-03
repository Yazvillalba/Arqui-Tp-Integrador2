package com.integrador2;

import java.io.IOException;
import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Repositories.CarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteCarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        CSVLoader loader = new CSVLoader();

        // try {
        // loader.loadEstudiantes("estudiantes.csv");
        // loader.loadCarrera("carreras.csv");

        // loader.insertarEstudiante();
        // loader.insertarCarrera();
        // CarreraRepositoryImpl eImpl = new CarreraRepositoryImpl();
        // List<Carrera> carreras = eImpl.obtenerTodas();
        // for (Carrera carrera : carreras) {
        // System.out.println(carrera.getNombre()+ " "+carrera.getId());
        // }

        // loader.loadEstudianteCarrera("estudianteCarrera.csv");
        // loader.insertarEstudianteCarrera();
        // } catch (IOException e) {
        // e.printStackTrace();
        // System.out.println("NO SE CARRRGOOOOOOOO");
        // }

        //Estudiante est1 = new Estudiante(43864400, "yazmin", "villalba", 22, "femenino", "Olavarria", 27500);
        // Estudiante est2 = new Estudiante(43864700,"marlene" , "carli", 100,
        // "femenino", "Olavarria",25450);
        // Estudiante est3 = new Estudiante(27150, 34942135, "Maria Edith",
        // "Esteberena", 44,"femenino", "Tandil");
        // Estudiante est4 = new Estudiante(3495513,"Juan Carlos" , "Ch...",
        // 40,"masculino", "Tandil", 25825);

        // EstudianteRepositoryImpl eImpl = new EstudianteRepositoryImpl();

        // eImpl.agregarEstudiante(est1);
        // eImpl.agregarEstudiante(est2);
        // eImpl.agregarEstudiante(est4);
        // System.out.println("obtener todos");
        // System.out.println(" ");
        // List<Estudiante> estudiantes = eImpl.obtenerTodos();

        // for (Estudiante estudiante : estudiantes) {
        //     System.out.println(estudiante.getNombre());
        // }
        // System.out.println(" ");
        // System.out.println("uno por libreta");

        // Estudiante estu1 = eImpl.obtenerUnoPorLibreta(27500);
        // System.out.println(estu1.getDni() + " " + estu1.getNombre() + " " + estu1.getApellido());
        // System.out.println(" ");
        // System.out.println("Todos los de genero: M");
        // List<Estudiante> EstudiantesMasc = eImpl.obtenerTodosPorGenero("masculino");
        // for (Estudiante estudiante : EstudiantesMasc) {
        //     System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
        // }
        // System.out.println(" ");
        // System.out.println("Todos los de genero: F");
        // List<Estudiante> EstudiantesFem = eImpl.obtenerTodosPorGenero("femenino");
        // for (Estudiante estudiante : EstudiantesFem) {
        //     System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
        // }
        // System.out.println(" ");
        // Estudiante estudporID = eImpl.obtenerPorId(23322529);
        // System.out.println(estudporID.getDni() + " " + estudporID.getNombre() + " " + estudporID.getApellido());

        // Estudiante est3 = eImpl.obtenerUnoPorLibreta(27500);
        // eImpl.eliminarEstudiante(est3);
        CarreraRepositoryImpl cImpl = new CarreraRepositoryImpl();
        // Carrera c = new Carrera("TUIDA", 3);
        // cImpl.agregarCarrera(c);
        System.out.println("Todas las carreras:");
        
        List<Carrera> carreras = cImpl.obtenerTodas();
        for (Carrera carrera : carreras) {
            System.out.println(carrera.getNombre() + " " + carrera.getId());
        }
        System.out.println(" ");
        System.out.println("Carrera por ID");
        Carrera carrera = cImpl.obtenerPorId(1);
        System.out.println(carrera.getNombre());
        System.out.println(" ");
        // EstudianteCarreraRepositoryImpl ecImpl = new EstudianteCarreraRepositoryImpl();
        // List<Estudiante> est= ecImpl.obtieneEstudiantesCarrera(carrera, "Tandil");
        // for (Estudiante estudiante : est) {
        //     System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " ");
        // }
        // Carrera carrera2 = cImpl.obtenerPorId(17);
        // cImpl.eliminarCarrera(carrera2);
    }
}