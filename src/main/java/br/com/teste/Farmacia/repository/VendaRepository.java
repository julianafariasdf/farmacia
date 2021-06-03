package br.com.teste.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{
	

}
