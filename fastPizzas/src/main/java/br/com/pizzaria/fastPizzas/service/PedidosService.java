package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Pedidos;
import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import br.com.pizzaria.fastPizzas.repository.PedidosRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;


    public void addPedido(Pedidos pedido) {
        pedidosRepository.save(pedido);
    }

    public void deletePedidoById(Long id) {
        pedidosRepository.deleteById(id);
    }

    public StatusPedido consultarStatusPedidoById(Long id) {

        Pedidos pedido = pedidosRepository.getReferenceById(id);
        return pedido.getStatusPedido();
    }

    public void alterarStatusPedidoById(Pedidos pedidos){
        try {
            Pedidos pedidoExiste = pedidosRepository.getReferenceById(pedidos.getId());
            pedidoExiste.setStatusPedido(pedidos.getStatusPedido());
            pedidosRepository.saveAndFlush(pedidoExiste);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Não foi possível alterar o status do pedido. Pedido não encontrado.");
        }


        // TODO: Corrigir.
        public void alterarInformacoesDoPedidoById(Pedidos pedidos){
            Pedidos pedidoExiste = pedidosRepository.findById(pedidos.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));

            pedidoExiste.setInformacoesPedido(pedidos.getInformacoesPedido());
            pedidosRepository.saveAndFlush(pedidoExiste);
        }

        }

    }
}
