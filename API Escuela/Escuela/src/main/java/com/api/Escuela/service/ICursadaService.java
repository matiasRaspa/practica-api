package com.api.Escuela.service;

import com.api.Escuela.model.dto.CursadaDTO;

import java.util.Set;

public interface ICursadaService {

    void crearCursada(CursadaDTO cursadaDTO);
    CursadaDTO leerCursadaPorId(Long id);
    void modificarCursada(CursadaDTO cursadaDTO);
    void eliminarCursadaPorId(Long id);
    Set<CursadaDTO> listarTodas();
}
