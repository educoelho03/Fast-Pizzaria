package br.com.pizzaria.fastPizzas.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cardapio")
@Table(name = "tb_cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String saboresSalgados;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String saboresDoces;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String bebidas;

    @Column(nullable = false,
            columnDefinition = "DECIMAL(4,2)")
    private Double preco;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(500)")
    private String descricao;

}
