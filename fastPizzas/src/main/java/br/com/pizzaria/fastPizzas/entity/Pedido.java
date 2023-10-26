package br.com.pizzaria.fastPizzas.entity;

import br.com.pizzaria.fastPizzas.enums.Pagamento;
import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

// Adicionar relacionamentos(ManyToMany, ManyToOne, OneToMany)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pedidos")
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "data_pedido"
            ,nullable = false,
            columnDefinition = "DATE")
    private LocalDateTime dataDoPedido;

    @NotNull
    @Column(name = "status_pedido",
            nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @Column(name = "informacao_pedido",
            nullable = false,
            columnDefinition = "VARCHAR(500)")
    private String informacoesPedido;

    @NotNull
    @Column(name = "forma_pagamento",
            nullable = false,
            columnDefinition = "VARCHA(25)")
    private Pagamento formaPagamento;
}
