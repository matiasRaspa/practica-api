package com.api.Escuela.controller;

import com.api.Escuela.model.dto.CursadaDTO;
import com.api.Escuela.model.dto.EstudianteDTO;
import com.api.Escuela.model.dto.MateriaDTO;
import com.api.Escuela.service.ICursadaService;
import com.api.Escuela.service.IEstudianteService;
import com.api.Escuela.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cursadas")
public class CursadaController {

    private final ICursadaService cursadaService;
    private final IEstudianteService estudianteService;
    private final IMateriaService materiaService;

    @Autowired
    public CursadaController(ICursadaService cursadaService, IEstudianteService estudianteService, IMateriaService materiaService) {
        this.cursadaService = cursadaService;
        this.estudianteService = estudianteService;
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<Set<CursadaDTO>> listarTodas(){
        Set<CursadaDTO> buscandoListaDeCursadas = cursadaService.listarTodas();
        if(buscandoListaDeCursadas == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(buscandoListaDeCursadas);
    }

    @GetMapping("{id}")
    public ResponseEntity<CursadaDTO> buscarCursadaPorId(@PathVariable Long id){
        CursadaDTO buscandoCursada = cursadaService.leerCursadaPorId(id);
        if(buscandoCursada == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(buscandoCursada);
    }

    @PostMapping
    public ResponseEntity<CursadaDTO> crearCursada(@RequestBody CursadaDTO cursadaDTO){
        EstudianteDTO buscandoEstudianteDTO = estudianteService.leerEstudiantePorId(cursadaDTO.getEstudiante().getId());
        MateriaDTO buscandoMateriaDTO = materiaService.leerMateriaPorId(cursadaDTO.getMateria().getId());
        if(buscandoEstudianteDTO == null || buscandoMateriaDTO == null || cursadaDTO.getNota() < 0.0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cursadaService.crearCursada(cursadaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CursadaDTO> modificarCursada(@RequestBody CursadaDTO cursadaDTO){
        CursadaDTO buscandoCursada = cursadaService.leerCursadaPorId(cursadaDTO.getId());
        if(buscandoCursada == null || cursadaDTO.getEstudiante().getId() == null || cursadaDTO.getMateria().getId() == null || cursadaDTO.getNota() < 0.0){
            return new ResponseEntity<CursadaDTO>(HttpStatus.BAD_REQUEST);
        }
        cursadaService.modificarCursada(cursadaDTO);
        return new ResponseEntity<CursadaDTO>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CursadaDTO> eliminarCursadaPorId(@PathVariable Long id){
        CursadaDTO buscandoCursada = cursadaService.leerCursadaPorId(id);
        if(buscandoCursada == null){
            return new ResponseEntity<CursadaDTO>(HttpStatus.NOT_FOUND);
        }
        cursadaService.eliminarCursadaPorId(id);
        return new ResponseEntity<CursadaDTO>(HttpStatus.OK);
    }
}
