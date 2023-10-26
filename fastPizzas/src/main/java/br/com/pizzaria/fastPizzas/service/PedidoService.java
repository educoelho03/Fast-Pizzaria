package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Pedido;
import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import br.com.pizzaria.fastPizzas.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void addPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido nao encontrado. " + id));
    }

//    OUTRA MANEIRA DE FAZER O GET DO ID DO PEDIDO, QUAL É MELHOR?
//    public Pedido getPedidoById(Long id){
//        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
//        return pedidoOptional.orElseThrow(() -> new EntityNotFoundException("Pedido nao encontrado"));
//    }

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

    public void cancelarPedidoById(Long id) {
        Pedido pedidoExiste = pedidoRepository.findById(pedidoRepository.getReferenceById(id).getId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));

        pedidoExiste.setStatusPedido(StatusPedido.valueOf("CANCELADO"));
    }

    public void deletePedidoById(Long id) {
        try {
            Pedido pedidoExiste = getPedidoById(id);
            pedidoRepository.delete(pedidoExiste);
        } catch (Exception e) {
            throw new RuntimeException("Pedido nao existe. " + id);
        }
    }

    public void atualizarStatusPedido(Long id){
        Pedido pedidoExiste = getPedidoById(id);

        //""();
    }
}
