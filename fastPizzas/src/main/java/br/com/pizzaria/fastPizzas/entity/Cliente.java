package br.com.pizzaria.fastPizzas.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Email(message = "Digite um email válido!")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "O telefone não pode ser nulo")
    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "cep", nullable = false)
    private Integer cep;
}
