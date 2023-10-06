package com.integrador2.Repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.integrador2.DTO.CarreraConInscriptos;
import com.integrador2.DTO.ReporteDTO;
import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;
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
    public List<CarreraConInscriptos> obtenerPorInscripto() {
         EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT new com.integrador2.DTO.CarreraConInscriptos(c.id_carrera, c.nombre, COUNT(*)) FROM Carrera c JOIN c.estudiantes e GROUP BY c.nombre, c.id_carrera ORDER BY COUNT(*) DESC";
            TypedQuery<CarreraConInscriptos> query = em.createQuery(jpql, CarreraConInscriptos.class);
 

            List<CarreraConInscriptos> carreras =  query.getResultList();
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
    public Carrera obtenerPorId(int id_carrera){
           EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT c FROM Carrera c WHERE c.id = :id_carrera";
            Query query = em.createQuery(jpql, Carrera.class);
            query.setParameter("id_carrera", id_carrera);

            Carrera carrera =  (Carrera) query.getSingleResult();
            return carrera;
        } finally {
            em.close();
        }
    }

        // QUERY QUE ANDA PERO NO DEVUELVE LOS NOMBRES DE LA CARRERA
        // (SELECT * FROM Carrera c
        // JOIN 
        // (SELECT ec.id_carrera, ec.anioInscripcion AS anio, COUNT(ec.anioInscripcion) AS inscriptos FROM EstudianteCarrera ec 
        // GROUP BY ec.id_carrera, ec.anioInscripcion) a
        // ON a.id_carrera = c.id_carrera
        // LEFT JOIN
        // (SELECT  ec.id_carrera, NULLIF(ec.graduacion,0) AS anio, COUNT(NULLIF(ec.graduacion,0)) AS graduados FROM EstudianteCarrera ec 
        // GROUP BY ec.id_carrera, ec.graduacion) g
        // ON g.id_carrera = c.id_carrera AND g.anio = a.anio)
        // UNION 
        // (SELECT * FROM Carrera c
        // JOIN 
        // (SELECT ec.id_carrera, ec.anioInscripcion AS anio, COUNT(ec.anioInscripcion) AS inscriptos FROM EstudianteCarrera ec 
        // GROUP BY ec.id_carrera, ec.anioInscripcion) a1
        // ON a1.id_carrera = c.id_carrera
        // RIGHT  JOIN
        // (SELECT  ec.id_carrera, NULLIF(ec.graduacion,0) AS anio, COUNT(NULLIF(ec.graduacion,0)) AS graduados FROM EstudianteCarrera ec 
        // GROUP BY ec.id_carrera, ec.graduacion) g
        // ON g.id_carrera = c.id_carrera AND g.anio = a1.anio
        // WHERE g.anio IS NOT NULL
        // ORDER BY c.nombre, a1.anio)
                

    @Override
    public List<ReporteDTO> generarReporteCarreras() {
        String jpql = "SELECT c.id_carrera, c.nombre, a.anioInscripcion AS anio, a.inscriptos, g.graduados FROM Carrera c " +
        "INNER JOIN " +
            "(SELECT ec.id_carrera AS id_carrera, ec.anioInscripcion, COUNT(ec.anioInscripcion) AS inscriptos FROM EstudianteCarrera ec " +
        "GROUP BY ec.id_carrera, ec.anioInscripcion) a " +
        "ON a.id_carrera = c.id_carrera " +
        "INNER JOIN " +
            "(SELECT ec.id_carrera AS id_carrera, ec.graduacion, COUNT(ec.graduacion) AS graduados FROM EstudianteCarrera ec " +
        "GROUP BY ec.id_carrera, ec.graduacion) g " +
        "ON g.id_carrera = c.id_carrera AND a.anioInscripcion = g.graduacion " +
        "ORDER BY c.nombre, a.anioInscripcion ";

        EntityManager em = EntityFactory.getInstance().createEntityManager();

        try {
            Query query = em.createNativeQuery(jpql);
            
            List<Object[]> results =  query.getResultList();
            List<ReporteDTO> reporte = new ArrayList<>();

            for (Object[] r : results){
                reporte.add(new ReporteDTO((Integer)r[0],(String)r[1],(Integer)r[2],(Long)r[3], (Long)r[3]));
            }
                
            return reporte;
        }  finally {
            em.close();
        }


    }

}
