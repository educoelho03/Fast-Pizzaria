package br.com.pizzaria.fastPizzas.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedidos {

    @Id
    private UUID id;
    private String dataDoPedido;
    private String horaDoPedido;
    private StatusPedido statusPedido;
    private String informacoesPedido;
}
