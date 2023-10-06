package com.integrador2.Factory;

import com.integrador2.Interfaces.CarreraRepository;
import com.integrador2.Interfaces.EstudianteCarreraRepository;
import com.integrador2.Interfaces.EstudianteRepository;
import com.integrador2.Repositories.CarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteCarreraRepositoryImpl;
import com.integrador2.Repositories.EstudianteRepositoryImpl;

public class FactoryRepositoryImpl implements FactoryRepository{
    private static FactoryRepositoryImpl factory;
	private final EstudianteRepository estudianteRepository;
	private final CarreraRepository carreraRepository;
	private final EstudianteCarreraRepository estudianteCarreraRepository;


    public FactoryRepositoryImpl() {
        this.estudianteRepository = new EstudianteRepositoryImpl();
        this.carreraRepository = new CarreraRepositoryImpl();
        this.estudianteCarreraRepository = new EstudianteCarreraRepositoryImpl();
    }
    public static FactoryRepositoryImpl getInstancia() {
        
		if(factory == null) {
			factory = new FactoryRepositoryImpl();
		}
		return factory;
	}
    @Override
    public EstudianteRepository obtenerEstudianteRepository() {
        return estudianteRepository;
    }

    @Override
    public CarreraRepository obtenerCarreraRepositorY() {
        return carreraRepository;
    }

    @Override
    public EstudianteCarreraRepository obtenerEstudianteCarreraRepository() {
       return estudianteCarreraRepository;
    }
    
}
