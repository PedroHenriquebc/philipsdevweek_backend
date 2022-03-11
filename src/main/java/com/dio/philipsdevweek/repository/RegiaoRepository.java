package com.dio.philipsdevweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.philipsdevweek.entity.Regiao;
@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long>{

}
