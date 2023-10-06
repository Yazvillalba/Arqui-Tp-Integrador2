package com.integrador2.DTO;

import java.io.Serializable;

public class ReporteDTO implements Serializable{
  private int id_carrera;
  private String nombreCarrera;
  private int anio;
  private Long inscriptos;
  private Long graduados;
  
  
  public ReporteDTO(int id_carrera, String nombreCarrera, Integer anio, Long inscriptos, Long graduados) {
    this.id_carrera = id_carrera;
    this.nombreCarrera = nombreCarrera;
    this.anio = anio;
    this.inscriptos = inscriptos;
    this.graduados = graduados;
  }
  
  public ReporteDTO() {
  }
  
  @Override
  public String toString() {
    return "ReporteDTO [id_carrera=" + id_carrera + ", nombreCarrera=" + nombreCarrera + ", anio=" + anio
        + ", inscriptos=" + inscriptos + ", graduados=" + graduados + "]";
  }

  public String getNombreCarrera() {
    return nombreCarrera;
  }

  public void setNombreCarrera(String nombreCarrera) {
    this.nombreCarrera = nombreCarrera;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int anio) {
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
