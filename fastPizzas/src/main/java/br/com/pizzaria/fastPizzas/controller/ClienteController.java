package br.com.pizzaria.fastPizzas.controller;

import br.com.pizzaria.fastPizzas.entity.Cliente;
import br.com.pizzaria.fastPizzas.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // Métodos HTTP:
    // GET: PEGAR
    // PUT: ATUALIZAR
    // POST: CRIAR

    @Autowired
    // TODO: Pesquisar sobre ResponseBody e RequestBody
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        clienteService.addCliente(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listagemClientes(){
        clienteService.getAllClientes();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> clientePorId(@PathVariable Long id){
        clienteService.getClientesById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<Cliente> atualizarDadosCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.updateCliente(id, cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar")
    @Transactional
    public ResponseEntity<Void> deletarCliente(){
        clienteService.deleteAllClientes();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> deletarClientePorId(@PathVariable Long id){
        clienteService.deleteClientesById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
