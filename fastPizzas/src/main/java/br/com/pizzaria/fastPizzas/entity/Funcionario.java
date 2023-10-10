package br.com.pizzaria.fastPizzas.entity;


import br.com.pizzaria.fastPizzas.enums.Cargos;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Funcionario")
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID Id;

    @Column(nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargos cargos;

    @Column(nullable = false,
            columnDefinition = "DATE")
    private LocalDate dataAdmissao;

}
