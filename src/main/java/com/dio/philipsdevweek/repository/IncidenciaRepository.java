package com.dio.philipsdevweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.philipsdevweek.entity.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long>{

}
