package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.repository.ClienteRepository;
import br.com.pizzaria.fastPizzas.repository.FuncionarioRepository;
import br.com.pizzaria.fastPizzas.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzariaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PedidosRepository pedidosRepository;
}
