package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Cardapio;
import br.com.pizzaria.fastPizzas.repository.CardapioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.mutation.internal.temptable.UpdateExecutionDelegate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioService {

    private final CardapioRepository cardapioRepository;

    public CardapioService(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    public List<Cardapio> getAllCardapio(){
        return cardapioRepository.findAll();
    }

    public Cardapio addItemCardapio(Cardapio item){
        return cardapioRepository.save(item);
    }

    public Cardapio getItemById(Long id){
        Optional<Cardapio> itemOptional = cardapioRepository.findById(id);
        return itemOptional.orElseThrow(() -> new EntityNotFoundException("Item não existente. " + id));
    }

    public void deletarItemById(Long id){
        try{
            Cardapio cardapioExiste = cardapioRepository.getReferenceById(id);
            cardapioRepository.delete(cardapioExiste);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Cardapio atualizarPrecoItem(Long id, Cardapio item){
        Cardapio cardapioExiste = cardapioRepository.getReferenceById(id);

        cardapioExiste.setPreco(item.getPreco());

        return cardapioRepository.saveAndFlush(cardapioExiste);
    }
}
