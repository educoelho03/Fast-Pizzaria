package br.com.pizzaria.fastPizzas.repository;

import br.com.pizzaria.fastPizzas.entity.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
