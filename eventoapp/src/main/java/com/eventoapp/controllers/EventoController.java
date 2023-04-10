package com.eventoapp.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repositry.ConvidadoRepositry;
import com.eventoapp.repositry.EventoRepository;
import jakarta.validation.Valid;


@Controller
public class EventoController {
	
	@Autowired // Toda vez que for necessário usar o evento repository, será criado uma instância automaticamente
	private EventoRepository er;
	
	@Autowired // Toda vez que for necessário usar o evento repository, será criado uma instância automaticamente
	private ConvidadoRepositry cr;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	//Requisição que salva os dados no banco
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEvento";
		}else {
			er.save(evento); //Persistindo os dados no banco
			attributes.addFlashAttribute("mensagem", "Evento adicionado com sucesso!");
			return "redirect:/cadastrarEvento";
		}
					
	}
	

	@GetMapping("/deletarEvento/{codigoEvento}")
	public String deletarEvento(@PathVariable("codigoEvento") long codigoEvento) {
		Evento evento = er.findByCodigoEvento(codigoEvento);
		ArrayList<Convidado> convidados = cr.findByEvento(evento);
		for(int x = 0; x < convidados.size(); x++) {
			cr.delete(convidados.get(x));
		}
		
		er.delete(evento);
		return "redirect:/";
	}
	
	@GetMapping(value="/{codigoEvento}") //Recebendo convidado
	public ModelAndView detalhesEvento(@PathVariable("codigoEvento") long codigoEvento) { //Recebe um valor da URL
		Evento evento = er.findByCodigoEvento(codigoEvento);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados",  convidados); //mandando para  view
		return mv;
	}
	
	
	//Salvando convidado
	@RequestMapping(value="/{codigoEvento}", method = RequestMethod.POST) 
	public String adicionarConvidado(@PathVariable("codigoEvento") long codigoEvento, @Valid Convidado convidado,  BindingResult result, RedirectAttributes attributes){
		boolean condicao = true;
		Evento evento = er.findByCodigoEvento(codigoEvento);
		ArrayList<Convidado> convidados = cr.findByEvento(evento); 
		
		
		for(int x = 0; x < convidados.size(); x++) {
			if(convidado.getCpf().equals(convidados.get(x).getCpf())) {
				condicao = false;
				break;
			}
		}
		
		
	    if(result.hasErrors() || condicao == false){
	    	attributes.addFlashAttribute("mensagem", "Verifique os campos!");
	        return "redirect:/{codigoEvento}";
	    }
	    else {
		    convidado.setEvento(evento);
		    cr.save(convidado);
		    attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		    return "redirect:/{codigoEvento}";
	    }
	}
	
	@GetMapping("/deletarConvidado/{codigoConvidado}")
	public String deletarConvidado(@PathVariable("codigoConvidado") long codigoConvidado) {
		Convidado convidado = cr.findByCodigoConvidado(codigoConvidado);
		long codigoEvento = convidado.getEvento().getCodigoEvento();
		cr.delete(convidado);
		return "redirect:/" +codigoEvento; 
	}
	
	
}