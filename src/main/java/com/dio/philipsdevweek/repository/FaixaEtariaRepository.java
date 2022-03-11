package com.dio.philipsdevweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.philipsdevweek.entity.FaixaEtaria;

@Repository
public interface FaixaEtariaRepository extends JpaRepository<FaixaEtaria, Long>{

}
