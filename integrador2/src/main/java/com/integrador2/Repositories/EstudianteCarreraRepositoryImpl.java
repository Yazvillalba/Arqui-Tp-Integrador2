package com.integrador2.Repositories;


import com.integrador2.Entidades.Carrera;
import com.integrador2.Entidades.Estudiante;
import com.integrador2.Entidades.EstudianteCarrera;
import com.integrador2.Factory.EntityFactory;
import com.integrador2.Interfaces.EstudianteCarreraRepository;

import jakarta.persistence.EntityManager;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository{
    
    @Override
    public void matricularEstudiante(Estudiante estudiante, Carrera carrera, int anioInscripcion, int graduacion, int antiguedad) {
        EntityManager em = EntityFactory.getInstance().createEntityManager();
        
        EstudianteCarrera estudianteCarrera = new EstudianteCarrera(estudiante, carrera, anioInscripcion, graduacion, antiguedad);

        try {
            em.getTransaction().begin();
            em.persist(estudianteCarrera);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    
}
