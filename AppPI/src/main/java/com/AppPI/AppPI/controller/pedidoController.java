package com.AppPI.AppPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.AppPI.AppPI.models.Pedido;
import com.AppPI.AppPI.repository.PedidoRepository;

@Controller
public class pedidoController {
	
	@Autowired
	private PedidoRepository pr;
	
	@RequestMapping(value = "/pedido", method = RequestMethod.GET)
	public String abrirpedido() {
		return "pedido/pedido";
	}
	
	@RequestMapping(value = "/pedido", method = RequestMethod.POST)
	public String gravarpedido(Pedido pedido) {
		pr.save(pedido);
		return "redirect:/pedido";
	}
	
	// LISTAR PEDIDOS
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listarpedido() {
		ModelAndView mv = new ModelAndView("pedido/listar");
		mv.addObject("pedido", pr.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/deletarPedido/{id}", method = RequestMethod.GET)
	public String deletarPedido(@PathVariable("id") long id) {
		pr.delete(pr.findById(id));
		return "redirect:/listar";
	}
	
	@RequestMapping(value = "editarPedido/{id}", method = RequestMethod.GET)
	public ModelAndView abrireditarpedido(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("pedido/editar");
		mv.addObject("pedido", pr.findById(id));
		return mv;
	}
	
	@RequestMapping(value = "/editarPedido/{id}", method = RequestMethod.POST)
	public String updatePedido(Pedido pedido) {
		pr.save(pedido);
		return "redirect:/listar";
	}

}
