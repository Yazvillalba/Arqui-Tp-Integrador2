package com.integrador2.Entidades;

import java.util.List;

import com.integrador2.DTO.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estudiante extends DTO {
    @Id
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;

    @Column(name="nro_libreta")
    private int nroLibreta;
    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCarrera> carreras;

    
    
    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int nroLibreta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.nroLibreta = nroLibreta;
    }
    public Estudiante(){
        
    }
    
    public int getNroLibreta() {
        return nroLibreta;
    }

    public void setNroLibreta(int nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<EstudianteCarrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<EstudianteCarrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String getCabeceraTabla() {
       return this.getNombreEspaciado("DNI", 15) + this.getNombreEspaciado("Nombre", 20)
                + this.getNombreEspaciado("Apellido", 20) + getNombreEspaciado("Edad", 10)
                + getNombreEspaciado("Genero", 20) + getNombreEspaciado("Ciudad", 20)
                + getNombreEspaciado("NroLibreta", 8);
    }

    @Override
    public String toString() {

        return getNombreEspaciado(Integer.toString(dni), 15) + getNombreEspaciado(nombre, 20)
                + getNombreEspaciado(apellido, 20) + getNombreEspaciado(Integer.toString(edad), 10)
                + getNombreEspaciado(genero, 20) + getNombreEspaciado(ciudad, 20)
                + getNombreEspaciado(Integer.toString(nroLibreta), 8);

    }
    
}