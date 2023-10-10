package br.com.pizzaria.fastPizzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cardapio")
@Table(name = "tb_cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String pizzaSalgada;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String pizzaDoce;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String bebidas;

    @Column(nullable = false,
            columnDefinition = "DECIMAL(4,2)")
    private Double preco;
}
