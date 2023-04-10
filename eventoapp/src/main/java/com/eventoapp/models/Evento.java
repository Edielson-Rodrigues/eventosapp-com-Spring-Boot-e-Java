package com.eventoapp.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity //Cria uma entidade no banco de dados
public class Evento implements Serializable{ //Implementando a iterface, possibilitando a class ser armezanada no B.D
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) //Criando um ID automaticamente
	private long codigoEvento;
	
	@NotEmpty
	private String nomeEvento;
	@NotEmpty
	private String local;
	@NotEmpty
	private String data;
	@NotEmpty
	private String horario;
	
	@OneToMany//primeiro vem a entidade em questão depois a do outro lado da relação
	private List<Convidado> convidado; //Uma lista de convidados
	
	public long getCodigoEvento() {
		return codigoEvento;
	}
	public void setCodigoEvento(long codigoEvento) {
		this.codigoEvento = codigoEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
