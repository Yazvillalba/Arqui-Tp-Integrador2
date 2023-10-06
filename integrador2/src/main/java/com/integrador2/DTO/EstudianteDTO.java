package com.integrador2.DTO;

import java.io.Serializable;

public class EstudianteDTO extends DTO implements Serializable{
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    
    private int nroLibreta;

    public EstudianteDTO(int dni, String nombre, String apellido, int edad, String genero, String ciudad,
            int nroLibreta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
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

    public int getNroLibreta() {
        return nroLibreta;
    }

    public void setNroLibreta(int nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    @Override
    public String getCabeceraTabla() {
        return this.getNombreEspaciado("dni", 15) +this.getNombreEspaciado("nombre", 20) +this.getNombreEspaciado("apellido", 20) +this.getNombreEspaciado("edad", 15)+this.getNombreEspaciado("genero", 20)+this.getNombreEspaciado("ciudad", 20) +this.getNombreEspaciado("nroLibreta", 10);
    }
    @Override
    public String toString(){
        return this.getNombreEspaciado(Integer.toString(dni), 15) + this.getNombreEspaciado(nombre, 20) + this.getNombreEspaciado(apellido, 20) + this.getNombreEspaciado(Integer.toString(edad), 15)+this.getNombreEspaciado(genero, 20) + this.getNombreEspaciado(ciudad, 20) + this.getNombreEspaciado(Integer.toString(nroLibreta), 15) ;
    }

    
}
