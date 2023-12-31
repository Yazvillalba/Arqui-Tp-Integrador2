package com.integrador2.Entidades;

import java.util.List;

import com.integrador2.DTO.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrera extends DTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private int idCarrera;
    private String nombre;
    private int duracion;
    
    @OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> estudiantes;

  

    public Carrera(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
    public Carrera(){}
    
    public int getId() {
        return idCarrera;
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
        this.idCarrera = id;
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
    @Override
    public String getCabeceraTabla() {
        return this.getNombreEspaciado("ID", 10) + this.getNombreEspaciado("Nombre", 30)+ this.getNombreEspaciado("Duración", 15);
    }
    
    @Override
    public String toString(){
        return this.getNombreEspaciado(Integer.toString(idCarrera), 10) + this.getNombreEspaciado(nombre, 30)+ this.getNombreEspaciado(Integer.toString(duracion), 15);
    }
   
}
