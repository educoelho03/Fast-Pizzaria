package br.com.pizzaria.fastPizzas.repository;

import br.com.pizzaria.fastPizzas.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, UUID> {
}
