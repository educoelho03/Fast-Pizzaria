package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Pedido;
import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import br.com.pizzaria.fastPizzas.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void addPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void getAllPedidos(){
        pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido nao encontrado. " + id));
    }

    public void deletePedidoById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public StatusPedido consultarStatusPedidoById(Long id) {

        Pedido pedido = pedidoRepository.getReferenceById(id);
        return pedido.getStatusPedido();
    }

    public void alterarStatusPedidoById(Long id, Pedido pedido) {
        try {
            Pedido pedidoExiste = pedidoRepository.getReferenceById(id);
            pedidoExiste.setStatusPedido(pedido.getStatusPedido());
            pedidoRepository.saveAndFlush(pedidoExiste);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Não foi possível alterar o status do pedido. Pedido não encontrado.");
        }
    }

    public void alterarInformacoesDoPedidoById(Long id, Pedido pedido) {
        Pedido pedidoExiste = pedidoRepository.findById(pedidoRepository.getReferenceById(id).getId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));

        pedidoExiste.setInformacoesPedido(pedido.getInformacoesPedido());
        pedidoRepository.saveAndFlush(pedidoExiste);
    }


}
