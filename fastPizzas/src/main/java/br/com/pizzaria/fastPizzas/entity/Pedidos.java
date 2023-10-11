package br.com.pizzaria.fastPizzas.entity;

import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime dataDoPedido;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(500)")
    private String informacoesPedido;
}
