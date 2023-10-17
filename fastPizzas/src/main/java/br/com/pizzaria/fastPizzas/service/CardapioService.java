package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Cardapio;
import br.com.pizzaria.fastPizzas.repository.CardapioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioService {

    private CardapioRepository cardapioRepository;

    public List<Cardapio> getAllCardapio(){
        return cardapioRepository.findAll();
    }

    public Cardapio getCardapioById(Long id){
        return cardapioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + id));
    }

    public void deletarItemById(Long id){
        cardapioRepository.deleteById(id);
    }

    public void addItemCardapio(Cardapio cardapio){
        cardapioRepository.save(cardapio);
    }

    public Cardapio alterarPrecoItem(Cardapio cardapio, Long id){
        Cardapio cardapioExiste = cardapioRepository.getReferenceById(id);

        cardapioExiste.setPreco(cardapio.getPreco());

        return cardapioRepository.saveAndFlush(cardapioExiste);
    }
}
