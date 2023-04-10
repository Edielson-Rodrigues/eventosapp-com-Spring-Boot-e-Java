package com.eventoapp.repositry;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{ //vai mandar os dados do cadastro para banco

	Evento findByCodigoEvento(long codigoEvento); //procurando por um codigo no banco
}
