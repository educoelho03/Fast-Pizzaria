package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Cliente;
import br.com.pizzaria.fastPizzas.exceptions.ClienteNotFoundException;
import br.com.pizzaria.fastPizzas.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
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

    @Transactional
    public Cliente updateCliente(Cliente cliente){
        if(cliente.getId() == null){
            throw new IllegalArgumentException("ID não encontrado");
        }

        Cliente clienteExiste = clienteRepository.getReferenceById(cliente.getId());

        clienteExiste.setNome(cliente.getNome());
        clienteExiste.setEndereco(cliente.getEndereco());
        clienteExiste.setCEP(cliente.getCEP());
        clienteExiste.setEmail(cliente.getEmail());
        clienteExiste.setTelefone(cliente.getTelefone());

        return clienteRepository.saveAndFlush(clienteExiste);
    }

    @Transactional
    public void deleteClientesById(Long id){
        try{
            clienteRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não foi possivel deletar o cliente de ID: " + id);
        }
    }

    @Transactional
    public void deleteAllClientes(){
        try {
            clienteRepository.deleteAll();
        } catch (Exception e){
            throw new RuntimeException("Não foi possivel deletar os clientes");
        }
    }
}
