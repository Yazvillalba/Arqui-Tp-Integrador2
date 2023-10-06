package com.integrador2.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EstudianteCarrera {
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
        return "EstudianteCarrera [id=" + id + ", estudiante=" + estudiante + ", carrera=" + carrera
                + ", anioInscripcion=" + anioInscripcion + ", graduacion=" + graduacion + ", antiguedad=" + antiguedad
                + "]";
    }
    
    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, int anioInscripcion, int  graduacion, int antiguedad) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.anioInscripcion = anioInscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }

    public EstudianteCarrera(){
        
    }
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

}
