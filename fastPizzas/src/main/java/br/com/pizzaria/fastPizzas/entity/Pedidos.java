package br.com.pizzaria.fastPizzas.entity;

import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pedidos")
@Table(name = "tb_pedido")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(nullable = false,
            columnDefinition = "DATE")
    private LocalDate dataDoPedido;

    @Column(nullable = false,
            columnDefinition = "DATE")
    private LocalDate horaDoPedido;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(500)")
    private String informacoesPedido;
}
