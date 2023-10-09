package br.com.pizzaria.fastPizzas.model;


import br.com.pizzaria.fastPizzas.enums.Cargos;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID Id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargos cargos;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

}
