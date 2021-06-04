package br.com.teste.Farmacia.repository;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.model.Produto;
import br.com.teste.Farmacia.model.Venda;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Testar o repository do Venda")
public class VendaRepositoryTeste {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private ClienteRepository clienteRepo;



    @Test
    @DisplayName("Salvar os Vendas")
    void salvarVenda() {
        Cliente cliente = clienteRepo.getById(1);
        Venda venda = new Venda(4, cliente);
        vendaRepo.save(venda);
        Assertions.assertThat(venda).isNotNull();
        Assertions.assertThat(venda.getId()).isNotNull();
    }

    @Test
    @DisplayName("Alterar os produtos")
    void alterarProduto() {
        Cliente cliente = clienteRepo.getById(1);
        Venda venda = new Venda(4, cliente);
        vendaRepo.save(venda);
        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(venda).isNotNull();
        Assertions.assertThat(venda.getId()).isNotNull();
    }

    @Test
    @DisplayName("Buscar todos os produtos")
    void buscarProduto() {
        List<Venda> produtos = new ArrayList<>();
        vendaRepo.findAll();
        Assertions.assertThat(produtos).isEmpty();
    }

    @Test
    @DisplayName("Buscar Vendas por Cliente")
    void buscarVendaPorCliente(){
        Cliente cliente = clienteRepo.getById(1);
        List<Venda> vendas = vendaRepo.consultarPorCliente(cliente);
        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(vendas).isNotNull();

    }

}
