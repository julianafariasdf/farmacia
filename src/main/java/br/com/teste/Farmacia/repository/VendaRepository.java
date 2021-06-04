package br.com.teste.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.model.Venda;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

    @Query("select u from Venda u where u.cliente = ?1")
    List<Venda> consultarPorCliente(Cliente cliente);
	

}
