package securitySix.service;

import org.springframework.data.repository.query.Param;
import securitySix.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    Pedido realizarPedido(List<Long> idsProdutos);


    List<Pedido> findAll(Long userId);

    Optional<Pedido> findById(@Param("pedidoId") Long pedidoId, @Param("userId") Long userId);

}
