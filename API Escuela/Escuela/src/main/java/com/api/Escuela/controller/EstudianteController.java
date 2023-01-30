package com.api.Escuela.controller;

import com.api.Escuela.model.dto.EstudianteDTO;
import com.api.Escuela.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<Set<EstudianteDTO>> listarTodos(){
        Set<EstudianteDTO> buscandoListaDeEstudiantes = estudianteService.listarTodos();
        if(buscandoListaDeEstudiantes == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(buscandoListaDeEstudiantes);
    }

    @GetMapping("{id}")
    public ResponseEntity<EstudianteDTO> buscarEstudiantePorId(@PathVariable Long id){
        EstudianteDTO buscandoEstudiante = estudianteService.leerEstudiantePorId(id);
        if(buscandoEstudiante == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(buscandoEstudiante);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        if(estudianteDTO.getNombre() == null || estudianteDTO.getApellido() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        estudianteService.crearEstudiante(estudianteDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstudianteDTO> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        EstudianteDTO buscandoEstudiante = estudianteService.leerEstudiantePorId(estudianteDTO.getId());
        if(buscandoEstudiante == null || estudianteDTO.getNombre() == null || estudianteDTO.getApellido() == null){
            return new ResponseEntity<EstudianteDTO>(HttpStatus.BAD_REQUEST);
        }
        estudianteService.modificarEstudiante(estudianteDTO);
        return new ResponseEntity<EstudianteDTO>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EstudianteDTO> eliminarEstudiantePorId(@PathVariable Long id){
        EstudianteDTO buscandoEstudiante = estudianteService.leerEstudiantePorId(id);
        if(buscandoEstudiante == null){
            return new ResponseEntity<EstudianteDTO>(HttpStatus.NOT_FOUND);
        }
        estudianteService.eliminarEstudiantePorId(id);
        return new ResponseEntity<EstudianteDTO>(HttpStatus.OK);
    }
}
