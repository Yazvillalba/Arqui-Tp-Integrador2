package com.integrador2;

import java.util.List;

import com.integrador2.DTO.CarreraConInscriptosDTO;
import com.integrador2.DTO.ReporteDTO;
import com.integrador2.Entidades.Carrera;
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

            System.out.println("\n----------- PRUEBA DE CARGA DE DATOS ------------------\n ");
            /*
             *  ----------- CARGA DE DATOS ---------------
             */
            loader.loadEstudiantes("estudiantes.csv");
            loader.loadCarrera("carreras.csv");
            loader.loadEstudianteCarrera("estudianteCarrera.csv");
             /*
             *  ----------- FIN CARGA DE DATOS ---------------
             */
            System.out.println("\n----------- FIN PRUEBA DE CARGA DE DATOS ------------------\n ");


             System.out.println("\n----------- PRUEBA DE METODOS CARRERA REPOSITORY ------------------\n ");

             /*
             *  ----------- PRUEBA DE METODOS CARRERA REPOSITORY ------------------
             */

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

             /*
             *  ----------- FIN PRUEBA DE METODOS CARRERA REPOSITORY ---------------
             */
            System.out.println("\n----------- FIN PRUEBA DE METODOS CARRERA REPOSITORY ------------------\n ");



            System.out.println("\n----------- PRUEBA DE METODOS ESTUDIANTE REPOSITORY ------------------\n ");

             /*
             *  ----------- PRUEBA DE METODOS ESTUDIANTE REPOSITORY ------------------
             */

             // TODO prueba de estudiante repository

             /*
             *  ----------- FIN PRUEBA DE METODOS ESTUDIANTE REPOSITORY ---------------
             */
            System.out.println("\n----------- FIN PRUEBA DE METODOS ESTUDIANTE REPOSITORY ------------------\n ");
            
           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en main");
        }

    }
}
