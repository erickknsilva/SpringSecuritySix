package securitySix.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import securitySix.domain.Produto;
import securitySix.dto.ProductRequest;
import securitySix.service.ProdutoService;

@RequestMapping("/produtos")
@RestController
@RequiredArgsConstructor
public class ProdutoWeb {


    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto created(@Valid @RequestBody ProductRequest request) {

        return produtoService.createdProduct(request);
    }


}
