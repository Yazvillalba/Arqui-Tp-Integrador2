package com.integrador2.DTO;

import java.io.Serializable;

public class ReporteDTO implements Serializable{

  private String nombreCarrera;
  private Long anio;
  private Long inscriptos;
  private Long graduados;
  
  
  public ReporteDTO( String nombreCarrera, Long anio, Long inscriptos, Long graduados) {

    this.nombreCarrera = nombreCarrera;
    this.anio = anio;
    this.inscriptos = inscriptos;
    this.graduados = graduados;
  }
  
  public ReporteDTO() {
  }
  
  public String obtenerCabeceraTabla(){
    return this.getFormattedName("Carrera", 40) + this.getFormattedName("Año", 20)
        + this.getFormattedName("Inscriptos", 20) + this.getFormattedName("Graduados", 20) ;
  }

  @Override
  public String toString() {
    return this.getFormattedName(nombreCarrera, 40) + this.getFormattedName(anio.toString(), 20)
        + this.getFormattedName(inscriptos.toString(),20) + this.getFormattedName(graduados.toString(), 20) ;
  }

  private String getFormattedName(String name, Integer size){
    if(name.length() < size){
      int missing = size - name.length();
      name += " ".repeat(missing);
    }
    return name;
  }

  public String getNombreCarrera() {
    return nombreCarrera;
  }

  public void setNombreCarrera(String nombreCarrera) {
    this.nombreCarrera = nombreCarrera;
  }

  public Long getAnio() {
    return anio;
  }

  public void setAnio(Long anio) {
    this.anio = anio;
  }

  public Long getInscriptos() {
    return inscriptos;
  }

  public void setInscriptos(Long inscriptos) {
    this.inscriptos = inscriptos;
  }

  public Long getGraduados() {
    return graduados;
  }

  public void setGraduados(Long graduados) {
    this.graduados = graduados;
  }
  
  
}
