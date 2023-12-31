package br.com.pizzaria.fastPizzas.repository;

import br.com.pizzaria.fastPizzas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
