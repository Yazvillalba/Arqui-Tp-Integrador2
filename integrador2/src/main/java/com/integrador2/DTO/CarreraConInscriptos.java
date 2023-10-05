package com.integrador2.DTO;

import java.io.Serializable;

public class CarreraConInscriptos implements Serializable{

    private int id;
    private String nombre;
    private Long nroInscriptos;
    
    public CarreraConInscriptos(int id, String nombre, Long nroInscriptos) {
        this.nombre = nombre;
        this.nroInscriptos = nroInscriptos;
    }

    @Override
    public String toString() {
      return "CarreraConInscripto [nombre=" + nombre + ", nroInscriptos=" + nroInscriptos + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
      return id;
    }

    public Long getNroInscriptos() {
      return nroInscriptos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
