package com.api.Escuela.service.impl;

import com.api.Escuela.model.Cursada;
import com.api.Escuela.model.dto.CursadaDTO;
import com.api.Escuela.repository.ICursadaRepository;
import com.api.Escuela.service.ICursadaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CursadaService implements ICursadaService {

    private final ICursadaRepository cursadaRepository;
    private final ObjectMapper mapper;

    @Autowired
    public CursadaService(ICursadaRepository cursadaRepository, ObjectMapper mapper) {
        this.cursadaRepository = cursadaRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public CursadaDTO leerCursadaPorId(Long id) {
        CursadaDTO cursadaDTO = null;
        Optional<Cursada> cursada = cursadaRepository.findById(id);

        if(cursada.isPresent()){
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }

        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public void eliminarCursadaPorId(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> listarTodas() {
        Set<CursadaDTO> listaDeCursadasDTO = new HashSet<>();
        List<Cursada> cursadas = cursadaRepository.findAll();

        if(!cursadas.isEmpty()){
            for(Cursada cursada : cursadas){
                CursadaDTO cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
                listaDeCursadasDTO.add(cursadaDTO);
            }
        }

        return listaDeCursadasDTO;
    }
}
