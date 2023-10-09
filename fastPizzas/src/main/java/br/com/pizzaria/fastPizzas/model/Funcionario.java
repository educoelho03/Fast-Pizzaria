package br.com.pizzaria.fastPizzas.model;


import br.com.pizzaria.fastPizzas.enums.Cargos;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    private UUID Id;
    private String nome;
    private Cargos cargos;
    private String dataAdmissao;

}
