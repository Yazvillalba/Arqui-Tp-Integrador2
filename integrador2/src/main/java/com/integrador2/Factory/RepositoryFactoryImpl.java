package com.integrador2.Factory;

import com.integrador2.Interfaces.CarreraRepository;
import com.integrador2.Interfaces.EstudianteCarreraRepository;
import com.integrador2.Interfaces.EstudianteRepository;
import com.integrador2.Repositories.CarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteCarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteRepositoryImpl;

public class RepositoryFactoryImpl implements RepositoryFactory{
    private static RepositoryFactoryImpl factory;
	private final EstudianteRepository estudianteRepository;
	private final CarreraRepository carreraRepository;
	private final EstudianteCarreraRepository estudianteCarreraRepository;


    public RepositoryFactoryImpl() {
        this.estudianteRepository = new EstudianteRepositoryImpl();
        this.carreraRepository = new CarreraRepositoryImpl();
        this.estudianteCarreraRepository = new EstudianteCarreraRepositoryImpl();
    }
    public static RepositoryFactoryImpl getInstancia() {
        
		if(factory == null) {
			factory = new RepositoryFactoryImpl();
		}
		return factory;
	}
    @Override
    public EstudianteRepository obtenerEstudianteRepository() {
        return estudianteRepository;
    }

    @Override
    public CarreraRepository obtenerCarreraRepository() {
        return carreraRepository;
    }

    @Override
    public EstudianteCarreraRepository obtenerEstudianteCarreraRepository() {
       return estudianteCarreraRepository;
    }
    
}
