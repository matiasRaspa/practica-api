package com.api.Escuela.model.dto;

public class MateriaDTO {

    private Long id;
    private String nombre;

    public MateriaDTO() {
        //No-args constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
