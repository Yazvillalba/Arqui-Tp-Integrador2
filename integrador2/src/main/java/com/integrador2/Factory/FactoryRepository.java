package com.integrador2.Factory;

import com.integrador2.Interfaces.CarreraRepository;
import com.integrador2.Interfaces.EstudianteCarreraRepository;
import com.integrador2.Interfaces.EstudianteRepository;

public interface FactoryRepository {
    EstudianteRepository obtenerEstudianteRepository();
    CarreraRepository obtenerCarreraRepository();
    EstudianteCarreraRepository obtenerEstudianteCarreraRepository();

}
