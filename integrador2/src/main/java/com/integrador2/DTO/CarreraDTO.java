package com.integrador2.DTO;

import java.io.Serializable;

public class CarreraDTO implements Serializable{
    private String nombre;
    private int duracion;
    
    public CarreraDTO(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
