package br.com.pizzaria.fastPizzas.model;
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
public class Cliente {

    @Id
    private UUID id;
    private String nome;
    private String endereco;
    private int CEP;
    private String email;
    private String telefone;
}
