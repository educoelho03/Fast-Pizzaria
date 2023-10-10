package br.com.pizzaria.fastPizzas.repository;

import br.com.pizzaria.fastPizzas.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, UUID> {
}
