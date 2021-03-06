package com.dio.philipsdevweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.philipsdevweek.entity.Regiao;
import com.dio.philipsdevweek.repository.RegiaoRepository;

@Service
public class RegiaoService {
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	public List<Regiao> findAll() {
		return regiaoRepository.findAll();
	}
	
	public Optional<Regiao> findById(Long id) {
		return regiaoRepository.findById(id);
	}
	
	public Regiao save(Regiao regiao) {
		return regiaoRepository.save(regiao);
	}
	
	public void deleteById(Long id) {
		regiaoRepository.deleteById(id);
	}
}
