package com.integrador2.DTO;

import java.io.Serializable;

public class CarreraDTO extends DTO implements Serializable{
    private String nombre;
    private int duracion;
    
    
    public CarreraDTO(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public CarreraDTO() {}


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

    @Override
    public String getCabeceraTabla() {
        return this.getNombreEspaciado("Nombre", 40) + this.getNombreEspaciado("Duracion", 10);
    }
    
    @Override
    public String toString(){
        return this.getNombreEspaciado(nombre, 40) + this.getNombreEspaciado(Integer.toString(duracion), 20);
    }

}
