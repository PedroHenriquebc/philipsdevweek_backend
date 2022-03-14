package com.dio.philipsdevweek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Incidencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	private Long regiao_id;
	private Long faixaEtaria_id;
	private Integer mes;
	private Integer qtd_exames;
	
	public Incidencia(Integer mes, Integer qtd_exames) {
		this.mes = mes;
		this.qtd_exames = qtd_exames;
	}
	public Incidencia() {}
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
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
	public Long getRegiao_id() {
		return regiao_id;
	}
	public Long getFaixaEtaria_id() {
		return faixaEtaria_id;
	}

}
