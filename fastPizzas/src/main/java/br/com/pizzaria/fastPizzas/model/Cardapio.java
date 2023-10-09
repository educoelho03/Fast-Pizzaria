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
public class Cardapio {

    @Id
    private UUID id;
    private String pizzaSalgada;
    private String pizzaDoce;
    private String bebidas;
    private double preco;
}
