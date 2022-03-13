package com.dio.philipsdevweek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Incidencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@ManyToOne
	private Regiao regiaoDoBrasil;
	
	private Integer mes;
	
	@ManyToOne
	private FaixaEtaria faixaEtaria;
	
	private Integer qtd_exames;
	
	public Incidencia(Regiao regiao, Integer mes, FaixaEtaria faixaEtaria, Integer qtd_exames) {
		this.regiaoDoBrasil = regiao;
		this.mes = mes;
		this.faixaEtaria = faixaEtaria;
		this.qtd_exames = qtd_exames;
	}
	public Incidencia() {}
	
	public Regiao getRegiao() {
		return regiaoDoBrasil;
	}
	public void setRegiao(Regiao regiao) {
		this.regiaoDoBrasil = regiao;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixa(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	public Integer getQtd_exames() {
		return qtd_exames;
	}
	public void setQtd_exames(Integer qtd_exames) {
		this.qtd_exames = qtd_exames;
	}
	public Long getId() {
		return id;
	}
	
	
}
