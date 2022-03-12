package com.dio.philipsdevweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.philipsdevweek.entity.FaixaEtaria;
import com.dio.philipsdevweek.service.FaixaEtariaService;

@RestController
@RequestMapping("/faixaetaria")
public class FaixaEtariaController {
	
	@Autowired
	FaixaEtariaService faixaEtariaService;
	
	@GetMapping
	public ResponseEntity<List<FaixaEtaria>> getFaixaEtarias(){
		List<FaixaEtaria> regioes = faixaEtariaService.findAll();
		return new ResponseEntity<>(regioes, HttpStatus.OK);
	}
	
	@GetMapping("/faixaetaria/{id}")
	public ResponseEntity<FaixaEtaria> getFaixaEtariaById(@RequestBody Long id){
		try {
			Optional<FaixaEtaria> faixaEtariaOptional = faixaEtariaService.findById(id);
			if(faixaEtariaOptional.isPresent()) {
				FaixaEtaria faixaEtaria = faixaEtariaOptional.get();
				return new ResponseEntity<>(faixaEtaria, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/faixaetaria/novo")
		public ResponseEntity<FaixaEtaria> postFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria) {
		faixaEtariaService.save(faixaEtaria);
		return new ResponseEntity<>(faixaEtaria, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/faixaetaria/remover/{id}")
	public ResponseEntity<?> deleteFaixaEtariaById(@PathVariable Long id){
		Optional<FaixaEtaria> faixaEtariaOptional = faixaEtariaService.findById(id);
		if(faixaEtariaOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			faixaEtariaService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
