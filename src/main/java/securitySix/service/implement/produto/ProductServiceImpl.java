package securitySix.service.implement.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import securitySix.domain.Produto;
import securitySix.dto.ProductRequest;
import securitySix.repository.ProdutoRepository;
import securitySix.service.ProdutoService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;


    @Override
    public Produto createdProduct(ProductRequest request) {

        Produto produto = new Produto(request.nome(), request.marca(), request.preco());

        return produtoRepository.save(produto);
    }
}
