package securitySix.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import securitySix.domain.Pedido;
import securitySix.domain.User;
import securitySix.dto.PedidoRequest;
import securitySix.service.PedidoService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/pedidos")
@RestController
public class PedidoWeb {

    private final PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed("USERS")
    public Pedido createdPedido(@Valid @RequestBody PedidoRequest request) {
        return pedidoService.realizarPedido(request.idsProdutos());
    }

    @GetMapping
    public List<Pedido> findAll() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return pedidoService.findAll(user.getId());
    }

    @GetMapping("/{pedidoId}")
    public Optional<Pedido> findById(@PathVariable Long pedidoId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return pedidoService.findById(pedidoId, user.getId());
    }


}
