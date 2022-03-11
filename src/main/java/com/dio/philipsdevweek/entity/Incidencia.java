package com.dio.philipsdevweek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Incidencia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	private Integer Regiao_id;
	private Integer Mes;
	private Long Faixa_id;
	private Integer Qtd_exames;
	public Incidencia(Integer regiao_id, Integer mes, Long faixa_id, Integer qtd_exames) {
		Regiao_id = regiao_id;
		Mes = mes;
		Faixa_id = faixa_id;
		Qtd_exames = qtd_exames;
	}
	public Incidencia() {}
	public Integer getRegiao_id() {
		return Regiao_id;
	}
	public void setRegiao_id(Integer regiao_id) {
		Regiao_id = regiao_id;
	}
	public Integer getMes() {
		return Mes;
	}
	public void setMes(Integer mes) {
		Mes = mes;
	}
	public Long getFaixa_id() {
		return Faixa_id;
	}
	public void setFaixa_id(Long faixa_id) {
		Faixa_id = faixa_id;
	}
	public Integer getQtd_exames() {
		return Qtd_exames;
	}
	public void setQtd_exames(Integer qtd_exames) {
		Qtd_exames = qtd_exames;
	}
	public Long getId() {
		return id;
	}
	
	
}
