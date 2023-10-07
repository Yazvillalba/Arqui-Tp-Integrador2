package com.integrador2;

import java.util.List;

import com.integrador2.DTO.CarreraConInscriptosDTO;
import com.integrador2.DTO.ReporteDTO;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Factory.RepositoryFactory;
import com.integrador2.Factory.RepositoryFactoryImpl;
import com.integrador2.Interfaces.CarreraRepository;
import com.integrador2.Interfaces.EstudianteCarreraRepository;
import com.integrador2.Interfaces.EstudianteRepository;

public class Main {
    public static void main(String[] args) {
        CSVLoader loader = new CSVLoader();
        
        try {
            RepositoryFactory repoFactory = new RepositoryFactoryImpl();
            EstudianteRepository estuRepo = repoFactory.obtenerEstudianteRepository();            
            EstudianteCarreraRepository estuCarrRepo = repoFactory.obtenerEstudianteCarreraRepository();            
            CarreraRepository carrRepo = repoFactory.obtenerCarreraRepository();            

            /*
            *  ----------- CARGA DE DATOS ---------------
            */
            System.out.println("\n----------- PRUEBA DE CARGA DE DATOS ------------------\n ");
            
            // loader.loadEstudiantes("estudiantes.csv");
            // loader.loadCarrera("carreras.csv");
            // loader.loadEstudianteCarrera("estudianteCarrera.csv");

            System.out.println("\n----------- FIN PRUEBA DE CARGA DE DATOS ------------------\n ");
             /*
             *  ----------- FIN CARGA DE DATOS ---------------
             */


            
            /*
            *  ----------- PRUEBA DE METODOS CARRERA REPOSITORY ------------------
            */
            System.out.println("\n----------- PRUEBA DE METODOS CARRERA REPOSITORY ------------------\n ");

            /* PRUEBA INSERCION */
            Carrera cNuevaReposteria = new Carrera("Repostería", 7);
            carrRepo.agregarCarrera(cNuevaReposteria);

            /* PRUEBA GET BY ID */
            Carrera cPorId = carrRepo.obtenerPorId(2);
            System.out.println("\nCarrera con ID = 2\n");
            System.err.println(cPorId.getCabeceraTabla());
            System.out.println(cPorId + "\n");

            /* PRUEBA GET ALL */
            List<Carrera> carreras = carrRepo.obtenerTodas();
            System.out.println("\nTodas las carreras:\n");
            System.out.println(cPorId.getCabeceraTabla());
            for (Carrera carrera : carreras) {
                System.out.println(carrera);
            }
            System.out.println("\n");

            /* PRUEBA GET POR CANT INSCRIPTOS */
            List<CarreraConInscriptosDTO> carrerasConInscr = carrRepo.obtenerPorCantInscriptos();
            System.out.println("\nCarreras ordenadas por inscriptos:\n");
            System.out.println(carrerasConInscr.get(1).getCabeceraTabla());
            for (CarreraConInscriptosDTO carrera : carrerasConInscr) {
                System.out.println(carrera);
            }
            System.out.println("\n");

            /* PRUEBA ELIMINAR CARRERA */
            carrRepo.eliminarCarrera(cNuevaReposteria);

            /* PRUEBA GENERAR REPORTE DE CARRERAS */
            List<ReporteDTO> reporte = carrRepo.generarReporteCarreras();
            System.out.println("\nReporte de inscriptos y graduados por c/año y por carrera:\n");
            System.out.println(reporte.get(1).getCabeceraTabla());
            for (ReporteDTO fila : reporte) {
                System.out.println(fila);
            }
            System.out.println("\n");

            System.out.println("\n----------- FIN PRUEBA DE METODOS CARRERA REPOSITORY ------------------\n ");

             /*
             *  ----------- FIN PRUEBA DE METODOS CARRERA REPOSITORY ---------------
             */


            
            /*
            *  ----------- PRUEBA DE METODOS ESTUDIANTE REPOSITORY ------------------
            */
            System.out.println("\n----------- PRUEBA DE METODOS ESTUDIANTE REPOSITORY ------------------\n ");

            /* PRUEBA INSERCION */
            Estudiante nEst = new Estudiante(41526300, "John", "Doe", 23, "Genderfluid", "Olavarria", 38588 );
            estuRepo.agregarEstudiante(nEst);

            /* PRUEBA GET BY ID */
            Estudiante estPorId = estuRepo.obtenerPorDni(12706636);
            System.out.println("\nEstudiante con DNI = 12706636\n");
            System.err.println(estPorId.getCabeceraTabla());
            System.out.println(estPorId + "\n");

            /* PRUEBA GET ALL */
            List<Estudiante> estudiantes = estuRepo.obtenerTodos();
            System.out.println("\nTodos los estudiantes:\n");
            System.out.println(estPorId.getCabeceraTabla());
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
            System.out.println("\n");
            
            /* PRUEBA GET BY NRO LIBRETA */
            Estudiante estPorNroLibreta = estuRepo.obtenerUnoPorLibreta(61607);
            System.out.println("\nEstudiante con Nro. Libreta = 61607\n");
            System.err.println(estPorNroLibreta.getCabeceraTabla());
            System.out.println(estPorNroLibreta + "\n");

            /* PRUEBA GET ALL FILTRADOS POR GENERO */
            List<Estudiante> estPorGenero = estuRepo.obtenerTodosPorGenero("Genderfluid");
            System.out.println("\nEstudiantes filtrados por genero = 'Genderfluid':\n");
            System.out.println(estPorNroLibreta.getCabeceraTabla());
            for (Estudiante estudiante : estPorGenero) {
                System.out.println(estudiante);
            }
            System.out.println("\n");

            /* PRUEBA ELIMINAR ESTUDIANTE */
            estuRepo.eliminarEstudiante(nEst);

            /* PRUEBA OBTENER ESTUDIANTE/S POR CARRERA Y CIUDAD */
            Carrera carr = carrRepo.obtenerPorId(7);
            List<Estudiante> estPorCarrYCiudad = estuRepo.obtenerEstudiantePorCarreraYCiudad(carr, "Sophia Antipolis" );
            System.out.println("\nEstudiantes filtrados por ciudad = 'Sophia Antipolis' y carrera id = 7:\n");
            System.out.println(estPorNroLibreta.getCabeceraTabla());
            for (Estudiante estudiante : estPorCarrYCiudad) {
                System.out.println(estudiante);
            }
            System.out.println("\n");

             System.out.println("\n----------- FIN PRUEBA DE METODOS ESTUDIANTE REPOSITORY ------------------\n ");
             /*
             *  ----------- FIN PRUEBA DE METODOS ESTUDIANTE REPOSITORY ---------------
             */
            
            /*
            *  ----------- PRUEBA DE METODOS ESTUDIANTE CARRERA REPOSITORY ------------------
            */
            System.out.println("\n----------- PRUEBA DE METODOS ESTUDIANTE CARRERA REPOSITORY ------------------\n ");

            /* PRUEBA INSERCION */
            Estudiante estNuevaMatricula = estuRepo.obtenerPorDni(17331470);
            Carrera carrNuevaMatricula = carrRepo.obtenerPorId(5);

            System.out.println("\nPrueba matriculación de estudiante");
            System.out.println("\nEstudiante: \n");
            System.out.println(estNuevaMatricula.getCabeceraTabla());
            System.out.println(estNuevaMatricula + "\n");
            System.out.println("\nCarrera: \n");
            System.out.println(carrNuevaMatricula.getCabeceraTabla());
            System.out.println(carrNuevaMatricula + "\n");

            estuCarrRepo.matricularEstudiante(estNuevaMatricula, carrNuevaMatricula, 2021, 2023, 2);

            String ciudad = estNuevaMatricula.getCiudad();
            List<Estudiante> estCarrYCiudadNuevaMatricula = estuRepo.obtenerEstudiantePorCarreraYCiudad(carrNuevaMatricula, ciudad );
            System.out.println("\nEstudiantes filtrados por ciudad = "+ ciudad +" y carrera ="+carrNuevaMatricula.getNombre()+":\n");
            System.out.println(estPorNroLibreta.getCabeceraTabla());
            for (Estudiante estudiante : estCarrYCiudadNuevaMatricula) {
                System.out.println(estudiante);
            }
            System.out.println("\n");



            System.out.println("\n----------- FIN PRUEBA DE METODOS ESTUDIANTE CARRERA REPOSITORY ------------------\n ");
            /*
            *  ----------- FIN PRUEBA DE METODOS ESTUDIANTE CARRERA REPOSITORY ---------------
            */
            
           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en main");
        }

    }
}
