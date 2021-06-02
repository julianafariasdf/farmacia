package br.com.teste.Farmacia.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> findAll(){
		
		List<Produto> produtos = produtoService.consultarTodos();
		
		return produtos;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Produto findById(@PathVariable Integer id) {
		
		Produto produto = produtoService.consultaPorId(id);		
		
		return produto;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Produto salvarProduto(@RequestBody Produto produto) {
		produto = produtoService.salvarProduto(produto);
		return produto;
	}

}
