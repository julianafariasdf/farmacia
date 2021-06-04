package br.com.teste.Farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.model.Venda;
import br.com.teste.Farmacia.repository.ClienteRepository;
import br.com.teste.Farmacia.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepo;
	
	public Venda consultaPorId(Integer id) {
		return vendaRepo.findById(id).get();
	}
	
	public List<Venda> consultarTodos(){
		return vendaRepo.findAll();
	}
	
	public Venda salvarVenda(Venda obj) {
		obj.setId(null); //Para garantir que o id do Objeto seja nulo.
		return vendaRepo.save(obj);
	}
	
	public Venda alterarVenda(Venda venda) {
		consultaPorId(venda.getId());
		return vendaRepo.save(venda);
	}
	
	public void delete(Integer id) {
		consultaPorId(id);
		vendaRepo.deleteById(id);
	}

	public Venda consultarPorCliente(Integer id){
		Venda venda = new Venda();
		venda.getCliente().getId();
		return vendaRepo.findById(venda.getCliente().getId()).get();
	}

}
