package com.api.Escuela.service.impl;

import com.api.Escuela.model.dto.EstudianteDTO;
import com.api.Escuela.service.IEstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstudianteServiceTest {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteServiceTest(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @Test
    void crearEstudiante() {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre("Rodrigo");
        estudianteDTO.setApellido("Marquez");
        estudianteService.crearEstudiante(estudianteDTO);
        EstudianteDTO comprobarCreacion = estudianteService.leerEstudiantePorId(1L);

        assertTrue(comprobarCreacion != null);
    }
}