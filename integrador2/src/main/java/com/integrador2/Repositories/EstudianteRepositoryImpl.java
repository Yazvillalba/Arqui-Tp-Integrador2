package com.integrador2.Repositories;

import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;
import com.integrador2.Factory.EntityFactory;
import com.integrador2.Interfaces.EstudianteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class EstudianteRepositoryImpl implements EstudianteRepository {

    @Override
    public void agregarEstudiante(Estudiante estudiante) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    @Override
    public List<Estudiante> obtenerTodos() {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        String jpql = "SELECT e FROM Estudiante e ORDER BY e.ciudad";
        try {
            Query query = em.createQuery(jpql);
            List<Estudiante> estudiantes = query.getResultList();
            return estudiantes;
        } finally {
            em.close();
        }

    }

    @Override
    public Estudiante obtenerUnoPorLibreta(int nroLibreta) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT e FROM Estudiante e WHERE e.nroLibreta = :nroLibreta";
            Query query = em.createQuery(jpql, Estudiante.class);
            query.setParameter("nroLibreta", nroLibreta);

            Estudiante estudiante = (Estudiante) query.getSingleResult();
            return estudiante;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Estudiante> obtenerTodosPorGenero(String genero) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT e FROM Estudiante e WHERE e.genero = ?1";
            Query query = em.createQuery(jpql, Estudiante.class);
            query.setParameter(1, genero);

            List<Estudiante> estudiantes = query.getResultList();
            return estudiantes;
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {

            Integer nroLibreta = estudiante.getNroLibreta();
            String jpql = "DELETE FROM Estudiante e WHERE e.nroLibreta = :nroLibreta";
            Query query = em.createQuery(jpql);
            query.setParameter("nroLibreta", nroLibreta);
            int rowsDeleted = query.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Estudiante eliminado con éxito");
            } else {
                System.out.println("No se encontró ningún estudiante con el número de libreta proporcionado.");
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
    public Estudiante obtenerPorId(int id_estudiante) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String jpql = "SELECT e FROM Estudiante e WHERE e.dni = :id_estudiante";
            Query query = em.createQuery(jpql, Estudiante.class);
            query.setParameter("id_estudiante", id_estudiante);

            Estudiante estudiante = (Estudiante) query.getSingleResult();
            return estudiante;
        } finally {
            em.close();
        }

    }

        @Override
    //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
    public List<Estudiante> obtenerEstudiantePorCarreraYCiudad(Carrera carrera, String ciudad) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String nombreCarrera = carrera.getNombre();
            //String ciudad = --;
            String jpql = 
            "SELECT e FROM EstudianteCarrera ec JOIN ec.estudiante e JOIN ec.carrera c WHERE c.nombre = :nombreCarrera AND e.ciudad = :ciudad";
            
            Query query = em.createQuery(jpql, EstudianteCarrera.class);

            query.setParameter("nombreCarrera", nombreCarrera);
            query.setParameter("ciudad", ciudad);

            List<Estudiante> estudiantes = query.getResultList();
            return estudiantes;
        } finally {
            em.close();
        }
    }

}
