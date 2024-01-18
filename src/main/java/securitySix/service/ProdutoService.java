package securitySix.service;

import securitySix.domain.Produto;
import securitySix.dto.ProductRequest;

public interface ProdutoService {

    Produto createdProduct(ProductRequest request);

}
