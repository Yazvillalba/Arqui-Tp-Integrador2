package com.integrador2.DTO;

import java.io.Serializable;

public class CarreraConInscriptosDTO extends DTO implements Serializable{

    private int id;
    private String nombre;
    private Long nroInscriptos;
    
    public CarreraConInscriptosDTO(int id, String nombre, Long nroInscriptos) {
        this.nombre = nombre;
        this.nroInscriptos = nroInscriptos;
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

  @Override
  public String getCabeceraTabla(){
    return this.getNombreEspaciado("Nombre", 40)
        + this.getNombreEspaciado("Número de Inscriptos", 10);
  }

  @Override
  public String toString() {
    return this.getNombreEspaciado(nombre, 40)
        + this.getNombreEspaciado(nroInscriptos.toString(),10);
  }
}
