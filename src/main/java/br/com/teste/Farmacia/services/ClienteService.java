package br.com.teste.Farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.Farmacia.model.Cliente;
import br.com.teste.Farmacia.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public Cliente consultaPorId(Integer id) {
		return clienteRepo.findById(id).get();
	}
	
	public List<Cliente> consultarTodos(){
		return clienteRepo.findAll();
	}
	
	public Cliente salvarCliente(Cliente obj) {
		obj.setId(null); //Para garantir que o id do Objeto seja nulo.
		return clienteRepo.save(obj);
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		consultaPorId(cliente.getId());
		return clienteRepo.save(cliente);
	}
	
	public void delete(Integer id) {
		consultaPorId(id);
		clienteRepo.deleteById(id);
	}

}
