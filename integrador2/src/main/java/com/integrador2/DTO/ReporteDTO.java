package com.integrador2.DTO;

import java.io.Serializable;

public class ReporteDTO extends DTO implements Serializable {

  private String nombreCarrera;
  private Long anio;
  private Long inscriptos;
  private Long graduados;
  
  
  public ReporteDTO(String nombreCarrera, Long anio, Long inscriptos, Long graduados) {
    this.nombreCarrera = nombreCarrera;
    this.anio = anio;
    this.inscriptos = inscriptos;
    this.graduados = graduados;
  }
  
  public ReporteDTO() {
  }
  
  @Override
  public String getCabeceraTabla(){
    return this.getNombreEspaciado("Carrera", 40) + this.getNombreEspaciado("Año", 20)
        + this.getNombreEspaciado("Inscriptos", 20) + this.getNombreEspaciado("Graduados", 20) ;
  }

  @Override
  public String toString() {
    return this.getNombreEspaciado(nombreCarrera, 40) + this.getNombreEspaciado(anio.toString(), 20)
        + this.getNombreEspaciado(inscriptos.toString(),20) + this.getNombreEspaciado(graduados.toString(), 20) ;
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
