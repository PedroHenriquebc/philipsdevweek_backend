package com.dio.philipsdevweek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	private String nome;
	private Long qtd_exames;
	
	public Regiao(String nome, Long qtd_exames) {
		this.nome = nome;
		this.qtd_exames = qtd_exames;
	}
	
	public Regiao(){}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQtd_exames() {
		return qtd_exames;
	}

	public void setQtd_exames(Long qtd_exames) {
		this.qtd_exames = qtd_exames;
	}
	
	
}
