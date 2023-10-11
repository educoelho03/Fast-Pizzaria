package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Cardapio;
import br.com.pizzaria.fastPizzas.repository.CardapioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {

    private CardapioRepository cardapioRepository;

    public List<Cardapio> getAllCardapio(){
        return cardapioRepository.findAll();
    }

    public void deletarItemById(Long id){
        cardapioRepository.deleteById(id);
    }


}
