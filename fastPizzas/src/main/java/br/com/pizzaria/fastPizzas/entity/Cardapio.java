package br.com.pizzaria.fastPizzas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    @Column(name = "produto",
            nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String nomeProduto;

    @Column(name = "categoriaProduto"
            ,nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String categoriaProduto;


    @Column(name = "preco",
            nullable = false,
            columnDefinition = "DECIMAL(8,2)")
    private BigDecimal preco;

    @Column(name = "descricao"
            ,nullable = false,
            columnDefinition = "VARCHAR(500)")
    private String descricao;

}
