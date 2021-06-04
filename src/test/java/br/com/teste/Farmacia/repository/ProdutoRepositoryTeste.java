package br.com.teste.Farmacia.repository;

import br.com.teste.Farmacia.model.Produto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@DisplayName("Testar o repository do Produto")
public class ProdutoRepositoryTeste {

    @Autowired
    private ProdutoRepository produtoRepo;

    @Test
    @DisplayName("Salvar os produtos")
    void salvarProduto() {
        Produto produto = new Produto(4, "Creme Cabelo");
        produtoRepo.save(produto);
        Assertions.assertThat(produto).isNotNull();
        Assertions.assertThat(produto.getId()).isNotNull();
        Assertions.assertThat(produto.getNomeProduto()).isNotNull();
    }

    @Test
    @DisplayName("Alterar os produtos")
    void alterarProduto() {
        Produto produto = new Produto(3, "Creme Cabelo");
        produtoRepo.save(produto);
        Assertions.assertThat(produto).isNotNull();
        Assertions.assertThat(produto.getId()).isNotNull();
        Assertions.assertThat(produto.getNomeProduto()).isNotNull();
    }

    @Test
    @DisplayName("Buscar todos os produtos")
    void buscarProduto() {
        List<Produto> produtos = new ArrayList<>();
        produtoRepo.findAll();
        Assertions.assertThat(produtos).isEmpty();
    }
}
