package securitySix.service.implement.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import securitySix.domain.Pedido;
import securitySix.domain.Produto;
import securitySix.domain.User;
import securitySix.domain.UserComprador;
import securitySix.repository.PedidoRepository;
import securitySix.repository.ProdutoRepository;
import securitySix.repository.UserCompradorRepository;
import securitySix.repository.UserRepository;
import securitySix.service.PedidoService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {


    private final UserRepository userRepository;

    private final PedidoRepository pedidoRepository;

    private final UserCompradorRepository userCompradorRepository;

    private final ProdutoRepository produtoRepository;

    @Override
    public List<Pedido> findAll(Long userId) {


        return pedidoRepository.findAll(userId).stream().sorted(Comparator.comparing(Pedido::getCreatedDate)).toList();
    }

    @Override
    public Optional<Pedido> findById(Long pedidoId, Long userId) {

        return pedidoRepository.findById(pedidoId, userId);
    }


    @Override
    public Pedido realizarPedido(List<Long> idsProdutos) {

        // Obter detalhes do usuário autenticado
        User userDetails = getUser();

        // Buscar o usuário comprador pelo nome de usuário
        UserComprador userComprador = saveUserComprador(getUser());

        // Buscar os produtos
        List<Produto> produtos = produtoRepository.findAllById(idsProdutos);

        // Criar o pedido
        Pedido pedido = Pedido.builder()
                .userComprador(userComprador)
                .produtos(produtos)
                .precoTotal(calcularPrecoTotal(produtos))
                .build();

        // Salvar o pedido no banco de dados
        return pedidoRepository.save(pedido);
    }

    private User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    private UserComprador saveUserComprador(User userDetails) {
        return userCompradorRepository.findByEmail(userDetails.getUsername())
                .orElseGet(() -> userCompradorRepository.save(new UserComprador(userDetails.getId(), userDetails.getUsername())));
    }


    private BigDecimal calcularPrecoTotal(List<Produto> produtos) {

        return produtos.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
