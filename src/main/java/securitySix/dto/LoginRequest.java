package securitySix.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank(message = "Insira o email")
        String username,
        @NotBlank(message = "Insira a senha")
        String password) {
}