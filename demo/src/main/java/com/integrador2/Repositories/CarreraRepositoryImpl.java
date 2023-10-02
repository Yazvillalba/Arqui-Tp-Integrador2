package com.integrador2.Repositories;

import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Factory.EntityFactory;
import com.integrador2.Interfaces.CarreraRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
    public List<Carrera> obtenerPorInscripto() {
         EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT c.nombre, COUNT(ec) AS cantidadInscritos FROM Carrera c JOIN c.EstudiantesCarrera ec GROUP BY c.nombre ORDER BY cantidadInscritos DESC";
            Query query = em.createQuery(jpql, Carrera.class);
 

            List<Carrera> carreras = query.getResultList();
            return carreras;
        } finally {
            em.close();
        }
    }

 
    @Override
    public void eliminarCarrera(Carrera carrera) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCarrera'");
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
            String jpql = "SELECT c FROM Carrera c WHERE c.id =:id_carrera";
            Query query = em.createQuery(jpql, Carrera.class);
            query.setParameter("id_carrera", id_carrera);

            Carrera carrera =  (Carrera) query.getSingleResult();
            return carrera;
        } finally {
            em.close();
        }
    }
}
