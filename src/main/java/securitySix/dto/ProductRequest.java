package securitySix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "Defina o nome do produto.")
        String nome,

        @NotBlank(message = "Insira a marca do produto.")
        String marca,

        @NotNull(message = "o preço do produto deve ser definido.")
        @Positive(message = "O preço do produto deve ser maior que zero.")
        BigDecimal preco


) {
}
