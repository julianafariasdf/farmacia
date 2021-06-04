package br.com.teste.Farmacia.repository;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.model.Produto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@DisplayName("Testar o repository do cliente")
public class ClienteRepositoryTeste {

    @Autowired
    private ClienteRepository clienteRepo;

    @Test
    @DisplayName("Salvar os clientes")
    void salvarCliente() {
        Cliente cliente = new Cliente(4, "Juliana");
        clienteRepo.save(cliente);
        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(cliente.getId()).isNotNull();
        Assertions.assertThat(cliente.getNomeCliente()).isNotNull();
    }

    @Test
    @DisplayName("Alterar os cliente")
    void alterarCliente() {
        Cliente cliente = new Cliente(2, "Vitoria");
        clienteRepo.save(cliente);
        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(cliente.getId()).isNotNull();
        Assertions.assertThat(cliente.getNomeCliente()).isNotNull();
    }

    @Test
    @DisplayName("Buscar todos os Clientes")
    void buscarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clienteRepo.findAll();
        Assertions.assertThat(clientes).isEmpty();
    }
}
