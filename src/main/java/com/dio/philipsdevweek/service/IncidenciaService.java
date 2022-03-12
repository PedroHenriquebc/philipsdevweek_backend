package com.dio.philipsdevweek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.philipsdevweek.entity.Incidencia;
import com.dio.philipsdevweek.repository.IncidenciaRepository;

@Service
public class IncidenciaService {

	@Autowired
	IncidenciaRepository incidenciaRepository;
	
	public List<Incidencia> findAll() {
		return incidenciaRepository.findAll();
	}
	
	public Optional<Incidencia> findById(Long id) {
		return incidenciaRepository.findById(id);
	}
	
	public Incidencia save(Incidencia incidencia) {
		return incidenciaRepository.save(incidencia);
	}
	
	public void deleteById(Long id) {
		incidenciaRepository.deleteById(id);
	}
}
