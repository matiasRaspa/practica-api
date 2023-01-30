package com.api.Escuela.repository;

import com.api.Escuela.model.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursadaRepository extends JpaRepository<Cursada, Long> {

}
