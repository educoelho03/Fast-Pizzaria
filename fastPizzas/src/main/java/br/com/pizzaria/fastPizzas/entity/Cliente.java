package br.com.pizzaria.fastPizzas.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cliente")
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Integer CEP;

    @Email
    @Column(nullable = false)
    private String email;

    @NotNull(message = "O telefone não pode ser nulo")
    private String telefone;
}
