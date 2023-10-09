package br.com.pizzaria.fastPizzas.model;

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
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private LocalDate dataDoPedido;
    private LocalDate horaDoPedido;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    private String informacoesPedido;
}
