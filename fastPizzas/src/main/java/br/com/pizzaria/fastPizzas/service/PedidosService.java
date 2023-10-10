package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;
}
