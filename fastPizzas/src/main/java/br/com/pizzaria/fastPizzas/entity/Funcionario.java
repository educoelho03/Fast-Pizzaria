package br.com.pizzaria.fastPizzas.entity;


import br.com.pizzaria.fastPizzas.enums.Cargos;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Funcionario")
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long Id;

    @Column(name = "nome",
            nullable = false,
            columnDefinition = "VARCHAR(255)")
    private String nome;

    @Column(name = "cpf",
            nullable = false,
            columnDefinition = "VARCHAR(11)")
    private String CPF;

    @Column(name = "cargo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargos cargo;

    @Column(name = "data_admissao",
            nullable = false,
            columnDefinition = "DATE")
    private LocalDate dataAdmissao;

}
