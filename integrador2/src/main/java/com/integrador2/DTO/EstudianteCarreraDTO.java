package com.integrador2.DTO;

import java.io.Serializable;

public class EstudianteCarreraDTO implements Serializable{
    private int anioInscripcion;
    private int graduacion;
    private int antiguedad;
    public EstudianteCarreraDTO(int anioInscripcion, int graduacion, int antiguedad) {
        this.anioInscripcion = anioInscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }
    public int getAnioInscripcion() {
        return anioInscripcion;
    }
    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }
    public int getGraduacion() {
        return graduacion;
    }
    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
}
