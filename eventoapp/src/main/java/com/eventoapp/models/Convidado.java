package com.eventoapp.models;


import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Convidado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigoConvidado;
	
	@NotEmpty
	private String nomeConvidado;

	@CPF
	private String cpf;
	//Indica que não pode ter valores vazio
	
	
	@ManyToOne //Relaçao de muitos para pouco, muitos convidados para um evento
	private Evento evento;
	
	
	public long getCodigoConvidado() {
		return codigoConvidado;
	}
	public void setCodigoConvidado(long codigoConvidado) {
		this.codigoConvidado = codigoConvidado;
	}
	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;		
	}
	
}


