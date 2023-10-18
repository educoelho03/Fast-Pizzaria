package br.com.pizzaria.fastPizzas.controller;

import br.com.pizzaria.fastPizzas.entity.Cardapio;
import br.com.pizzaria.fastPizzas.service.CardapioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping("/itens")
    public ResponseEntity<List<Cardapio>> listagemItens(Cardapio cardapio){
        cardapioService.getAllCardapio();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<Cardapio> cadastrarItem(Cardapio item){
        cardapioService.addItemCardapio(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/itens/{id}")
    public ResponseEntity<Cardapio> itensPorId(@PathVariable Long id){
        cardapioService.getCardapioById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cardapio> atualizarPrecoItemPorId(@PathVariable Long id, @RequestBody Cardapio item){
        cardapioService.atualizarPrecoItem(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> deletarItemPorId(@PathVariable Long id){
        cardapioService.deletarItemById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
