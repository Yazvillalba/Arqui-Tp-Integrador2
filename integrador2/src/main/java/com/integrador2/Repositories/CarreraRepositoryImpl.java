package com.integrador2.Repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.integrador2.DTO.CarreraConInscriptosDTO;
import com.integrador2.DTO.CarreraDTO;
import com.integrador2.DTO.ReporteDTO;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Factory.EntityFactory;
import com.integrador2.Interfaces.CarreraRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CarreraRepositoryImpl implements CarreraRepository{

    @Override
    public void agregarCarrera(Carrera carrera) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    @Override
    public List<CarreraConInscriptosDTO> obtenerPorCantInscriptos() {
         EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT new com.integrador2.DTO.CarreraConInscriptosDTO(c.id_carrera, c.nombre, COUNT(*)) FROM Carrera c JOIN c.estudiantes e GROUP BY c.nombre, c.id_carrera ORDER BY COUNT(*) DESC";
            TypedQuery<CarreraConInscriptosDTO> query = em.createQuery(jpql, CarreraConInscriptosDTO.class);
 

            List<CarreraConInscriptosDTO> carreras =  query.getResultList();
            return carreras;
        } finally {
            em.close();
        }
    }

 
    @Override
    public void eliminarCarrera(Carrera carrera) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {

            Integer id_carrera = carrera.getId();
            String jpql = "DELETE FROM Carrera c WHERE c.id_carrera = :id_carrera";
            Query query = em.createQuery(jpql);
            query.setParameter("id_carrera", id_carrera);
            int rowsDeleted = query.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Carrera eliminada con éxito");
            } else {
                System.out.println("No se encontró ningúna carrera con el id proporcionado.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Carrera> obtenerTodas() {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        String jpql = "SELECT c FROM Carrera c";
        try {
            Query query = em.createQuery(jpql);
            List<Carrera> carreras = query.getResultList();
            return carreras;
        } finally {
            em.close();
        }
    }

    @Override
    public CarreraDTO obtenerPorId(int idCarrera){
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        String jpql = "SELECT new com.integrador2.DTO.CarreraDTO(c.nombre, c.duracion) FROM Carrera c WHERE c.idCarrera=:idCarrera";

        try {
            Query query = em.createQuery(jpql, CarreraDTO.class);
            query.setParameter("idCarrera", idCarrera);

            CarreraDTO carrera =  (CarreraDTO) query.getSingleResult();
            return carrera;
        } finally {
            em.close();
        }
    }

    @Override
    public List<ReporteDTO> generarReporteCarreras() {
        String jpql = "WITH  "+
        "Inscripciones AS ( "+
            "SELECT  ec.id_carrera, c.nombre, ec.anio_inscripcion AS anio, COUNT(ec.anio_inscripcion) AS inscriptos  "+
                "FROM EstudianteCarrera ec  "+
                "JOIN Carrera c  "+
                "ON c.id_carrera = ec.id_carrera "+
            "GROUP BY ec.id_carrera, ec.anio_inscripcion), "+
         ""+
        "Graduaciones AS (  "+
            "SELECT  ec.id_carrera, c.nombre, NULLIF(ec.graduacion,0) AS anio, COUNT(NULLIF(ec.graduacion,0)) AS graduados  "+
                "FROM EstudianteCarrera ec  "+
                "JOIN Carrera c  "+
                    "ON c.id_carrera = ec.id_carrera "+
                "WHERE NULLIF(ec.graduacion,0) IS NOT NULL "+
            "GROUP BY ec.id_carrera, ec.graduacion) "+
             ""+
            "SELECT IF(i.nombre IS NOT NULL, i.nombre, g.nombre) AS carrera, CAST(IF(i.nombre IS NOT NULL, i.anio, g.anio) as UNSIGNED) AS anio, CAST(COALESCE(i.inscriptos, 0) as UNSIGNED) AS inscriptos,  CAST(COALESCE(g.graduados, 0) as UNSIGNED) AS graduados "+
                "FROM Inscripciones i "+
                    "LEFT JOIN  "+
                "(SELECT * FROM Graduaciones) g "+
                    "ON g.nombre = i.nombre AND g.anio = i.anio "+
             ""+
                "UNION  "+
             ""+
            "SELECT  IF(i.nombre IS NOT NULL, i.nombre, g.nombre) AS carrera, CAST(IF(i.nombre IS NOT NULL, i.anio, g.anio) as UNSIGNED) AS anio, CAST(COALESCE(i.inscriptos, 0) as UNSIGNED) AS inscriptos,  CAST(COALESCE(g.graduados, 0) as UNSIGNED) AS graduados "+
                "FROM Inscripciones i "+
                    "RIGHT JOIN  "+
                "(SELECT * FROM Graduaciones) g "+
                    "ON g.nombre = i.nombre AND g.anio = i.anio "+
            "ORDER BY carrera,  anio ASC ";

        EntityManager em = EntityFactory.getInstance().createEntityManager();

        try {
            Query query = em.createNativeQuery(jpql);
            
            List<Object[]> results =  query.getResultList();
            List<ReporteDTO> reporte = new ArrayList<>();

            for (Object[] r : results){
                reporte.add(new ReporteDTO((String)r[0],(Long)r[1],(Long)r[2], (Long)r[3]));
            }
                     
            return reporte;
        }  finally {
            em.close();
        }


    }
      public Carrera obtenerPorId2(int idCarrera){
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        String jpql = "SELECT c FROM Carrera c WHERE c.idCarrera=:idCarrera";

        try {
            Query query = em.createQuery(jpql, Carrera.class);
            query.setParameter("idCarrera", idCarrera);

            Carrera carrera =  (Carrera) query.getSingleResult();
            return carrera;
        } finally {
            em.close();
        }
    }
}
