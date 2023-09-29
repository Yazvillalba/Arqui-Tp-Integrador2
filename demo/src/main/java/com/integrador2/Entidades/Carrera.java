package com.integrador2.Entidades;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int duracion;
    
    @OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> estudiantes;

    
    public Carrera(String nombre, int duracion, List<EstudianteCarrera> estudiantes) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = estudiantes;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public List<EstudianteCarrera> getEstudiantes() {
        return estudiantes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setEstudiantes(List<EstudianteCarrera> estudiantes) {
        this.estudiantes = estudiantes;
    } 
    
}
