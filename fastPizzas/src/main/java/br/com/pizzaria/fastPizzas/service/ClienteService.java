package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Cliente;
import br.com.pizzaria.fastPizzas.exceptions.ClienteNotFoundException;
import br.com.pizzaria.fastPizzas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void addCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    public Cliente getClientesById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    public void updateCliente(Long id, Cliente cliente){
        if(cliente.getId() == null){
            throw new IllegalArgumentException("ID não encontrado");
        }

        Cliente clienteExiste = clienteRepository.getReferenceById(id);

        clienteExiste.setNome(cliente.getNome());
        clienteExiste.setEndereco(cliente.getEndereco());
        clienteExiste.setCEP(cliente.getCEP());
        clienteExiste.setEmail(cliente.getEmail());
        clienteExiste.setTelefone(cliente.getTelefone());

        clienteRepository.saveAndFlush(clienteExiste);
    }

    public void deleteClientesById(Long id){
        try{
            clienteRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não foi possivel deletar o cliente de ID: " + id);
        }
    }

    public void deleteAllClientes(){
        try {
            clienteRepository.deleteAll();
        } catch (Exception e){
            throw new RuntimeException("Não foi possivel deletar os clientes");
        }
    }
}
