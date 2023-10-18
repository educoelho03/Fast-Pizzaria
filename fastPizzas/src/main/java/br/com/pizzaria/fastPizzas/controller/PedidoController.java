package br.com.pizzaria.fastPizzas.controller;

import br.com.pizzaria.fastPizzas.entity.Pedido;
import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import br.com.pizzaria.fastPizzas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        pedidoService.addPedido(pedido);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<Pedido> listagemPedidos(){
        pedidoService.getAllPedidos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/consultarStatus/{id}")
    public ResponseEntity<StatusPedido> consultarStatus(@PathVariable Long id){
        pedidoService.consultarStatusPedidoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/alterarStatus/{id}")
    public ResponseEntity<Pedido> alterarStatus(@PathVariable Long id, @RequestBody Pedido pedido){
        pedidoService.alterarStatusPedidoById(id, pedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/alterarInformacoes/{id}")
    public ResponseEntity<Pedido> alterarInformacoes(@PathVariable Long id, @RequestBody Pedido pedido){
        pedidoService.alterarInformacoesDoPedidoById(id, pedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletarPedido/{id}")
    public ResponseEntity<Void> deletarPedidoPorId(@PathVariable Long id){
        pedidoService.deletePedidoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
