package com.integrador2;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.integrador2.DTO.CarreraDTO;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Interfaces.CarreraRepository;
import com.integrador2.Interfaces.EstudianteRepository;
import com.integrador2.Repositories.CarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteCarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteRepositoryImpl;

public class CSVLoader {
    private EstudianteRepository estudianteRepository;
    private CarreraRepository carreraRepository;
    private EstudianteCarreraRepositoryImpl estudianteCarreraRepository;
    public CSVParser getParser(String filePath) throws IOException {
        return CSVFormat.DEFAULT.withHeader().parse(new FileReader(filePath));
    }

    public CSVLoader() {
        this.estudianteRepository = new EstudianteRepositoryImpl();
        this.carreraRepository = new CarreraRepositoryImpl();
        this.estudianteCarreraRepository = new EstudianteCarreraRepositoryImpl();
    }

    public void loadEstudiantes(String filePath) throws IOException {
        CSVParser parser = this.getParser("integrador2\\src\\main\\java\\com\\integrador2\\Resources\\estudiantes.csv");
        try {
            for (CSVRecord row : parser) {
                Estudiante estudiante = new Estudiante(
                        Integer.parseInt(row.get("DNI")),
                        row.get("nombre"),
                        row.get("apellido"),
                        Integer.parseInt(row.get("edad")),
                        row.get("genero"),
                        row.get("ciudad"), Integer.parseInt(row.get("LU")));

                estudianteRepository.agregarEstudiante(estudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCarrera(String filePath) throws IOException {
        CSVParser parser = this.getParser("integrador2\\src\\main\\java\\com\\integrador2\\Resources\\carreras.csv");
        try {
            for (CSVRecord row : parser) {
                Carrera carrera = new Carrera(row.get("carrera"), Integer.parseInt(row.get("duracion")));
                carreraRepository.agregarCarrera(carrera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadEstudianteCarrera(String filePath) throws IOException {
        CSVParser parser = this.getParser("integrador2\\src\\main\\java\\com\\integrador2\\Resources\\estudianteCarrera.csv");
        try {
            for (CSVRecord row : parser) {
                int idEstudiante = Integer.parseInt(row.get("id_estudiante"));
                int idCarrera = Integer.parseInt(row.get("id_carrera"));
               
                Estudiante estudiante = estudianteRepository.obtenerPorId(idEstudiante);
                CarreraDTO carrera = carreraRepository.obtenerPorId(idCarrera);
                
                estudianteCarreraRepository.matricularEstudiante(estudiante, carrera, Integer.parseInt(row.get("inscripcion")),Integer.parseInt(row.get("graduacion")),Integer.parseInt(row.get("antiguedad")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }     
}
