package com.api.Escuela.controller;

import com.api.Escuela.model.dto.MateriaDTO;
import com.api.Escuela.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final IMateriaService materiaService;

    @Autowired
    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<Set<MateriaDTO>> listarTodas(){
        Set<MateriaDTO> buscandoListaDeMaterias = materiaService.listarTodas();
        if(buscandoListaDeMaterias == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(buscandoListaDeMaterias);
    }

    @GetMapping("{id}")
    public ResponseEntity<MateriaDTO> buscarMateriaPorId(@PathVariable Long id){
        MateriaDTO buscandoMateria = materiaService.leerMateriaPorId(id);
        if(buscandoMateria == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(buscandoMateria);
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> crearMateria(@RequestBody MateriaDTO materiaDTO){
        if(materiaDTO.getNombre() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        materiaService.crearMateria(materiaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MateriaDTO> modificarMateria(@RequestBody MateriaDTO materiaDTO){
        MateriaDTO buscandoMateria = materiaService.leerMateriaPorId(materiaDTO.getId());
        if(buscandoMateria == null || materiaDTO.getNombre() == null){
            return new ResponseEntity<MateriaDTO>(HttpStatus.BAD_REQUEST);
        }
        materiaService.modificarMateria(materiaDTO);
        return new ResponseEntity<MateriaDTO>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MateriaDTO> eliminarMateriaPorId(@PathVariable Long id){
        MateriaDTO buscandoMateria = materiaService.leerMateriaPorId(id);
        if(buscandoMateria == null){
            return new ResponseEntity<MateriaDTO>(HttpStatus.NOT_FOUND);
        }
        materiaService.eliminarMateriaPorId(id);
        return new ResponseEntity<MateriaDTO>(HttpStatus.OK);
    }
}
