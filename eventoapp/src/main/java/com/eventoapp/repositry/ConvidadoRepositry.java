package com.eventoapp.repositry;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;

public interface ConvidadoRepositry extends CrudRepository<Convidado, String>{

	ArrayList<Convidado> findByEvento(Evento evento);
	Convidado findByCodigoConvidado(long codigoConvidado);
	
}
