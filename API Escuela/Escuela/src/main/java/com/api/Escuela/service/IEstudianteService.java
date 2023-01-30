package com.api.Escuela.service;

import com.api.Escuela.model.dto.EstudianteDTO;

import java.util.Set;

public interface IEstudianteService {

    void crearEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO leerEstudiantePorId(Long id);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiantePorId(Long id);
    Set<EstudianteDTO> listarTodos();
}
