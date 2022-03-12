package com.dio.philipsdevweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.philipsdevweek.entity.FaixaEtaria;
import com.dio.philipsdevweek.repository.FaixaEtariaRepository;

@Service
public class FaixaEtariaService {

	@Autowired
	FaixaEtariaRepository faixaEtariaRepository;
	
	public List<FaixaEtaria> findAll(){
		return faixaEtariaRepository.findAll();
	}
	
	public Optional<FaixaEtaria> findById(Long id){
		return faixaEtariaRepository.findById(id);
	}
	
	public FaixaEtaria save(FaixaEtaria faixaEtaria) {
		return faixaEtariaRepository.save(faixaEtaria);
	}
	
	public void deleteById(Long id) {
		faixaEtariaRepository.deleteById(id);
	}
}
