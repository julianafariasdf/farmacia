package br.com.teste.Farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.services.ClienteService;


@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findAll(){
		List<Cliente> clientes = clienteService.consultarTodos();		
		return clientes;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Cliente consultarPorId(@PathVariable Integer id) {		
		return clienteService.consultaPorId(id);			
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.salvarCliente(cliente);
		return cliente;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Cliente alterarCliente(@RequestBody Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		cliente = clienteService.alterarCliente(cliente);
		return cliente;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deletarCliente(@PathVariable Integer id) {
		clienteService.delete(id);
	}
 
}
