package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;



}
