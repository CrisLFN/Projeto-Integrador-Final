package com.AppPI.AppPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.AppPI.AppPI.models.Cliente;
import com.AppPI.AppPI.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String abrircliente() {
		return "cliente/cliente";
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String gravarcliente(Cliente cliente) {
		cr.save(cliente);
		return "redirect:/cliente";
	}
	
	// LISTAR CLIENTES
		@RequestMapping(value = "/lista-cliente", method = RequestMethod.GET)
		public ModelAndView listacliente() {
			ModelAndView mv = new ModelAndView("cliente/lista-cliente");
			mv.addObject("cliente", cr.findAll());
			return mv;
		}
		
		@RequestMapping(value = "/deletarCliente/{id}", method = RequestMethod.GET)
		public String deletarCliente(@PathVariable("id") long id) {
			cr.delete(cr.findById(id));
			return "redirect:/lista-cliente";
		}
		
		@RequestMapping(value = "editarCliente/{id}", method = RequestMethod.GET)
		public ModelAndView abrireditarcliente(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("cliente/editar-cliente");
			mv.addObject("cliente", cr.findById(id));
			return mv;
		}
		
		@RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.POST)
		public String updateCliente(Cliente cliente) {
			cr.save(cliente);
			return "redirect:/lista-cliente";
		}
	
	

}
