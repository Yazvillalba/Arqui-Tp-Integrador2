package com.integrador2.Repositories;

import java.util.List;

import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;
import com.integrador2.Factory.EntityFactory;
import com.integrador2.Interfaces.EstudianteCarreraRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository{
    

    @Override
    //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
    public List<Estudiante> obtieneEstudiantesCarrera(Carrera carrera, String ciudadResidencia) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            String nombreCarrera = carrera.getNombre();
            //String ciudadResidencia = --;
            String jpql = 
            "SELECT e FROM EstudianteCarrera ec JOIN Estudiante e JOIN Carrera c WHERE c.nombre = :nombreCarrera AND e.ciudad = :ciudadResidencia";
            Query query = em.createQuery(jpql, EstudianteCarrera.class);
            query.setParameter("nombreCarrera", nombreCarrera);
            query.setParameter("ciudadResidencia", ciudadResidencia);
            List<Estudiante> estudiantes = query.getResultList();
            return estudiantes;
        
        } finally {
            em.close();
        }
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante, Carrera carrera) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matricularEstudiante'");
    }

    public void agregarEstudianteCarrera(EstudianteCarrera estudianteCarreras) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estudianteCarreras);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
