package br.com.teste.Farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Farmacia.model.Venda;
import br.com.teste.Farmacia.services.VendaService;


@RestController
@RequestMapping(value="/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Venda> findAll(){
		List<Venda> vendas = vendaService.consultarTodos();		
		return vendas;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Venda consultarPorId(@PathVariable Integer id) {		
		return vendaService.consultaPorId(id);			
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Venda salvarVenda(@RequestBody Venda venda) {
		venda = vendaService.salvarVenda(venda);
		return venda;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Venda alterarVenda(@RequestBody Venda venda, @PathVariable Integer id) {
		venda.setId(id);
		venda = vendaService.alterarVenda(venda);
		return venda;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deletarVenda(@PathVariable Integer id) {
		vendaService.delete(id);
	}
 
}
