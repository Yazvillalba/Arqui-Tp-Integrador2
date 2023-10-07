package com.integrador2.Entidades;

import com.integrador2.DTO.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EstudianteCarrera extends DTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @Column(name="anio_inscripcion")
    private int anioInscripcion;
    private int graduacion;
    private int antiguedad;

    
    @Override
    public String toString() {
        return getNombreEspaciado(Integer.toString(id), 5) + getNombreEspaciado(estudiante.getNombre() + " " + estudiante.getApellido(), 30) + getNombreEspaciado(carrera.getNombre(), 40)
                + getNombreEspaciado(Integer.toString(anioInscripcion), 10) + getNombreEspaciado(Integer.toString(graduacion), 10) + getNombreEspaciado(Integer.toString(antiguedad), 10);
        }
    
    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, int anioInscripcion, int  graduacion, int antiguedad) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.anioInscripcion = anioInscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }

    public EstudianteCarrera(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public Carrera getCarrera() {
        return carrera;
    }
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    public int getAnioInscripcion() {
        return anioInscripcion;
    }
    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }
   
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public int isGraduacion() {
        return graduacion;
    }
    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }

    @Override
    public String getCabeceraTabla() {
         return getNombreEspaciado("ID", 5) + getNombreEspaciado("Estudiante", 30) + getNombreEspaciado("Carrera", 40)
                + getNombreEspaciado("Año inscripción", 10) + getNombreEspaciado("Graduación", 10) + getNombreEspaciado("Antiguedad", 10);
    }

}
