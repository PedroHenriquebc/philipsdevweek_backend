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

import com.dio.philipsdevweek.entity.Regiao;
import com.dio.philipsdevweek.service.RegiaoService;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {

	@Autowired
	private RegiaoService regiaoService;
	
	@GetMapping
	public ResponseEntity<List<Regiao>> getRegioes(){
		List<Regiao> regioes = regiaoService.findAll();
		if(regioes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(regioes, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Regiao> getRegiaoById(@PathVariable Long id){
		try {
			Optional<Regiao> regiaoOptional = regiaoService.findById(id);
			if (regiaoOptional.isPresent()){
	            Regiao regiao = regiaoOptional.get();
	            return new ResponseEntity<>(regiao, HttpStatus.OK);
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Regiao> postRegiao(@RequestBody Regiao regiao) {
		regiaoService.save(regiao);
		return new ResponseEntity<>(regiao, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> deleteRegiaoById(@PathVariable Long id){
		Optional<Regiao> regiaoOptional = regiaoService.findById(id);
		if(regiaoOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			regiaoService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
