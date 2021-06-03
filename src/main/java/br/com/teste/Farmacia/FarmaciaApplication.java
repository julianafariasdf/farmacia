package br.com.teste.Farmacia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.model.Produto;
import br.com.teste.Farmacia.model.Venda;
import br.com.teste.Farmacia.repository.ClienteRepository;
import br.com.teste.Farmacia.repository.ProdutoRepository;
import br.com.teste.Farmacia.repository.VendaRepository;

@SpringBootApplication
public class FarmaciaApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private VendaRepository vendaRepo;

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto produto1 = new Produto(null, "Remedio");
		Produto produto2 = new Produto(null, "Creme");
		Produto produto3 = new Produto(null, "Fralda");
		
		produtoRepo.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		Cliente cliente1 = new Cliente(null, "Juliana");
		Cliente cliente2 = new Cliente(null, "Vitoria");
		
		clienteRepo.saveAll(Arrays.asList(cliente1, cliente2));
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(produto1);
		produtos.add(produto2);
		
		Venda venda = new Venda(null, cliente1);
		Venda venda1 = new Venda(null, cliente2);
		
		venda.getProdutos().addAll(Arrays.asList(produto1, produto2));
		venda1.getProdutos().addAll(Arrays.asList(produto3));
		
		vendaRepo.saveAll(Arrays.asList(venda, venda1));
		
		
		
		
		
		
	}

}
