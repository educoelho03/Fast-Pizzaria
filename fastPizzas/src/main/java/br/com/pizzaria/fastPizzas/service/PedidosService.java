package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Pedidos;
import br.com.pizzaria.fastPizzas.enums.StatusPedido;
import br.com.pizzaria.fastPizzas.repository.PedidosRepository;
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

    public void alterarStatusPedidoById(Pedidos pedidos) throws Exception {
        Optional<Pedidos> pedidoExiste = pedidosRepository.findById(pedidos.getId());

        if (pedidoExiste.isPresent()) {
            Pedidos pedido = pedidoExiste.get();
            pedido.setStatusPedido(pedidos.getStatusPedido());
            pedidosRepository.saveAndFlush(pedido);
        } else {
            throw new Exception("Não foi possivel alterar o status do pedido.");
        }

        // TODO: Corrigir.
        public void alterarInformacoesDoPedidoById(Pedidos pedidos){
            Optional<Pedidos> pedidoExiste = pedidosRepository.findById(pedidos.getId());

            if (pedidoExiste.isPresent()) {
                Pedidos pedido = pedidoExiste.get();
                pedido.setInformacoesPedido(pedidos.getInformacoesPedido());

                pedidosRepository.saveAndFlush(pedidos);
            } else {
                throw new Exception("Nao foi possivel alterar as informações do pedido");
            }
        }



    }
}
