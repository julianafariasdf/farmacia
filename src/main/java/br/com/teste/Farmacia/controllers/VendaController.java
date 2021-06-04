package br.com.teste.Farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	//Consultar todas as vendas
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> vendas = vendaService.consultarTodos();		
		return ResponseEntity.ok().body(vendas);
	}

	//Consultar vendas por Id
	@RequestMapping(value="/consultar/id={id}",method = RequestMethod.GET)
	public ResponseEntity<Venda> consultarPorId(@PathVariable Integer id) {
		Venda venda = vendaService.consultaPorId(id);
		return ResponseEntity.ok().body(venda);
	}

	//Consultar vendas por Id
	@RequestMapping(value="/consultarPorCliente/id={id}",method = RequestMethod.GET)
	public ResponseEntity<Venda> consultarPorCliente(@PathVariable Integer id) {
		Venda venda = vendaService.consultarPorCliente(id);
		return ResponseEntity.ok().body(venda);
	}

	//Salvar Vendas
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ResponseEntity<Venda> salvarVenda(@RequestBody Venda venda) {
		venda = vendaService.salvarVenda(venda);
		return ResponseEntity.ok().body(venda);
	}

	//Alterar vendas por id
	@RequestMapping(value="/alterar/id={id}", method = RequestMethod.PUT)
	public ResponseEntity<Venda> alterarVenda(@RequestBody Venda venda, @PathVariable Integer id) {
		venda.setId(id);
		venda = vendaService.alterarVenda(venda);
		return ResponseEntity.ok().body(venda);
	}

	//Excluir Vendas por Id
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarVenda(@PathVariable Integer id) {
		vendaService.delete(id);
		return ResponseEntity.noContent().build();
	}
 
}
