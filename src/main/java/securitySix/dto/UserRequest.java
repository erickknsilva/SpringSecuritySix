package securitySix.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record UserRequest(
        @NotBlank(message = "Insira o email")
        @Email(message = "Tente algo como example@gmail.com")
        String username,

        @NotBlank(message = "Insira a senha")
        String password,

        @NotEmpty(message = "Insira a(s) autoridade(s)")
        Set<Long> authorityIds) {
}
