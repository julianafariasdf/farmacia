package br.com.teste.Farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.Farmacia.model.Produto;
import br.com.teste.Farmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	public Produto consultaPorId(Integer id) {
		return produtoRepo.findById(id).get();
	}
	
	public List<Produto> consultarTodos(){
		return produtoRepo.findAll();
	}
	
	public Produto salvarProduto(Produto obj) {
		obj.setId(null); //Para garantir que o id do Objeto seja nulo.
		return produtoRepo.save(obj);
	}
	
	public Produto alterarProduto(Produto produto) {
		consultaPorId(produto.getId());
		return produtoRepo.save(produto);
	}
	
	public void delete(Integer id) {
		consultaPorId(id);
		produtoRepo.deleteById(id);
	}

}
