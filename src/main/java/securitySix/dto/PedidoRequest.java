package securitySix.dto;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record PedidoRequest(
        List<Long> idsProdutos

) {
}
