package com.dio.philipsdevweek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.philipsdevweek.entity.Regiao;
import com.dio.philipsdevweek.service.RegiaoService;

@RestController
@RequestMapping("/regiao")
public class RegiaoController {

	@Autowired
	private RegiaoService regiaoService;
	
	@GetMapping
	public ResponseEntity<List<Regiao>> findAll(){
		List<Regiao> regioes = regiaoService.findAll();
		return new ResponseEntity<>(regioes, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Regiao> findById(@PathVariable Long id){
		Optional<Regiao> regiaoOptional = regiaoService.findById(id);
		if (regiaoOptional.isPresent()){
            Regiao regiao = regiaoOptional.get();
            return new ResponseEntity<>(regiao, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
