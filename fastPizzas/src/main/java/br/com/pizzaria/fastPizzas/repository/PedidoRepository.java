package br.com.pizzaria.fastPizzas.repository;

import br.com.pizzaria.fastPizzas.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
