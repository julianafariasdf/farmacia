package br.com.teste.Farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Farmacia.model.Produto;
import br.com.teste.Farmacia.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	//Consultar todos os produtos
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> produtos = produtoService.consultarTodos();
		return ResponseEntity.ok().body(produtos);
	}

	//Consultar produtos por Id
	@RequestMapping(value="/consultar/id={id}",method = RequestMethod.GET)
	public ResponseEntity<Produto> consultarPorId(@PathVariable Integer id) {
		Produto produto = produtoService.consultaPorId(id);
		return ResponseEntity.ok().body(produto);
	}

	//Salvar cadastro produto
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		produto = produtoService.salvarProduto(produto);
		return ResponseEntity.ok().body(produto);
	}

	//Alterar produto por id
	@RequestMapping(value="/alterar/id={id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto, @PathVariable Integer id) {
		produto.setId(id);
		produto = produtoService.alterarProduto(produto);
		return ResponseEntity.ok().body(produto);
	}
	
	@RequestMapping(value="/excluir/id={id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
 
}
