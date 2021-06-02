package br.com.teste.Farmacia;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.teste.Farmacia.model.Produto;
import br.com.teste.Farmacia.repository.ProdutoRepository;

@SpringBootApplication
public class FarmaciaApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepo;

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto produto1 = new Produto(null, "Remedio");
		Produto produto2 = new Produto(null, "Creme");
		Produto produto3 = new Produto(null, "Fralda");
		
		produtoRepo.saveAll(Arrays.asList(produto1, produto2, produto3));
		
	}

}
