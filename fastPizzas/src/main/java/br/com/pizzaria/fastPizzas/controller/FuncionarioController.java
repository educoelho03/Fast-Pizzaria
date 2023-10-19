package br.com.pizzaria.fastPizzas.controller;

import br.com.pizzaria.fastPizzas.entity.Funcionario;
import br.com.pizzaria.fastPizzas.service.FuncionarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    // TODO: DUVIDA - Pq passar o construtor ao inves do @Autowired
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<Funcionario> cadastrarFuncionario(Funcionario funcionario){
        funcionarioService.addFuncionario(funcionario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listagemFuncionarios(){
        funcionarioService.getAllFuncionarios();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar/{id]")
    public ResponseEntity<Funcionario> funcionarioPorId(@PathVariable Long id){
        funcionarioService.getFuncionarioById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<Funcionario> atualizarDadosFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        funcionarioService.updateFuncionario(id, funcionario);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deletar")
    @Transactional
    public ResponseEntity<Void> deletarFuncionario(){
        funcionarioService.deleteAllFuncionarios();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> deletarFuncionarioPorId(@PathVariable Long id){
        funcionarioService.deleteFuncionariosById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
