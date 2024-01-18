package securitySix.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import securitySix.dto.LoginRequest;
import securitySix.dto.TokenDto;
import securitySix.service.implement.authJwtFilter.AutheticationServiceImpl;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class AuthenticationWeb {

    private final AutheticationServiceImpl autheticationService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TokenDto auth(@RequestBody @Valid LoginRequest request) {
        return autheticationService.authentication(request);
    }


}
