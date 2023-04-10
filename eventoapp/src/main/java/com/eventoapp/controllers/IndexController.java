package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.models.Evento;
import com.eventoapp.repositry.EventoRepository;

@Controller
public class IndexController {
	
	@Autowired
	private EventoRepository er;
	
	//Mandando dados do banco para o index(exibir eventos)
	@RequestMapping("/")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll(); //Cria uma lista com todos os eventos do banco, recebe como valor o nome da class que dar origem ao banco
			
		//Passando a lista de eventos para view
		mv.addObject("eventos", eventos); //recebe o mesmo nome que está no th:each
			
		return mv;
	}
}
