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

    public void addItemCardapio(Cardapio item){
        cardapioRepository.save(item);
    }

    public Cardapio getCardapioById(Long id){
        return cardapioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + id));
    }

    public void deletarItemById(Long id){
        cardapioRepository.deleteById(id);
    }

    public void alterarPrecoItem(Long id, Cardapio item){
        Cardapio cardapioExiste = cardapioRepository.getReferenceById(id);

        cardapioExiste.setPreco(item.getPreco());

        cardapioRepository.saveAndFlush(cardapioExiste);
    }
}
