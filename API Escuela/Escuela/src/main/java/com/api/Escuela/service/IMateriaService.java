package com.api.Escuela.service;

import com.api.Escuela.model.dto.MateriaDTO;

import java.util.Set;

public interface IMateriaService {

    void crearMateria(MateriaDTO materiaDTO);
    MateriaDTO leerMateriaPorId(Long id);
    void modificarMateria(MateriaDTO materiaDTO);
    void eliminarMateriaPorId(Long id);
    Set<MateriaDTO> listarTodas();
}
