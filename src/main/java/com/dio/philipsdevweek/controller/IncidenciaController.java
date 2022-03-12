package com.dio.philipsdevweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.philipsdevweek.entity.Incidencia;
import com.dio.philipsdevweek.service.IncidenciaService;

@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {

	@Autowired
	IncidenciaService incidenciaService;

	@GetMapping
	public ResponseEntity<List<Incidencia>> getRegioes() {
		List<Incidencia> incidencias = incidenciaService.findAll();
		if(incidencias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(incidencias, HttpStatus.OK);
	}

	@GetMapping("/incidencia/{id}")
	public ResponseEntity<Incidencia> getIncidenciaById(@PathVariable Long id) {
		try {
			Optional<Incidencia> incidenciaOptional = incidenciaService.findById(id);
			if (incidenciaOptional.isPresent()) {
				Incidencia incidencia = incidenciaOptional.get();
				return new ResponseEntity<>(incidencia, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/incidencia/novo")
	public ResponseEntity<Incidencia> postIncidencia(@RequestBody Incidencia incidencia) {
		incidenciaService.save(incidencia);
		return new ResponseEntity<>(incidencia, HttpStatus.CREATED);
	}
}
