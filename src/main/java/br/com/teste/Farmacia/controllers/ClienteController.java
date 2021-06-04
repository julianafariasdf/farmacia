package br.com.teste.Farmacia.controllers;

import java.util.List;

import br.com.teste.Farmacia.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	//Consultar todos os clientes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clienteService.consultarTodos();
		return ResponseEntity.ok().body(clientes);
	}

	//Consultar por id do cliente
	@RequestMapping(value="/consultar/id={id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> consultarPorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.consultaPorId(id);
		return ResponseEntity.ok().body(cliente);
	}

	//Salvar cadastro de cliente
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.salvarCliente(cliente);
		return ResponseEntity.ok().body(cliente);
	}

	//Alterar Cliente por id
	@RequestMapping(value="/alterar/id={id}", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		cliente = clienteService.alterarCliente(cliente);
		return ResponseEntity.ok().body(cliente);
	}

	//Excluir cliente por Id
	@RequestMapping(value="/excluir/id={id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
 
}
