package com.api.Escuela.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursadas")
public class Cursada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
    private double nota;

    public Cursada() {
        //No-args constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Cursada{" +
                "id=" + id +
                ", estudiante=" + estudiante +
                ", materia=" + materia +
                ", nota=" + nota +
                '}';
    }
}
