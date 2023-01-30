package com.api.Escuela.service.impl;

import com.api.Escuela.model.Estudiante;
import com.api.Escuela.model.dto.EstudianteDTO;
import com.api.Escuela.repository.IEstudianteRepository;
import com.api.Escuela.service.IEstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IEstudianteService {

    private final IEstudianteRepository estudianteRepository;
    private final ObjectMapper mapper;

    @Autowired
    public EstudianteService(IEstudianteRepository estudianteRepository, ObjectMapper mapper) {
        this.estudianteRepository = estudianteRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public EstudianteDTO leerEstudiantePorId(Long id) {
        EstudianteDTO estudianteDTO = null;
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);

        if(estudiante.isPresent()){
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }

        return estudianteDTO;
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiantePorId(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Set<EstudianteDTO> listarTodos() {
        Set<EstudianteDTO> listaDeEstudiantesDTO = new HashSet<>();
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        if(!estudiantes.isEmpty()){
            for(Estudiante estudiante : estudiantes){
                EstudianteDTO estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
                listaDeEstudiantesDTO.add(estudianteDTO);
            }
        }

        return listaDeEstudiantesDTO;
    }
}
