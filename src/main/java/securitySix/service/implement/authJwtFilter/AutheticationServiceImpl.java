package securitySix.service.implement.authJwtFilter;

import org.springframework.stereotype.Service;
import securitySix.domain.User;
import securitySix.dto.LoginRequest;
import securitySix.dto.TokenDto;
import securitySix.service.AutheticationService;
import securitySix.service.UserDetailsServiceTwo;

@Service
public class AutheticationServiceImpl implements AutheticationService {

    private final UserDetailsServiceTwo userDetailsServiceTwo;

    private final TokenServiceImpl tokenService;

    public AutheticationServiceImpl(UserDetailsServiceTwo userDetailsServic, TokenServiceImpl tokenService) {
        this.userDetailsServiceTwo = userDetailsServic;
        this.tokenService = tokenService;
    }

    @Override
    public TokenDto authentication(LoginRequest request) {

        try {

            User user = userDetailsServiceTwo.loadUserByUsername(request.username(), request.password());

            String token = tokenService.generatedToken(user.getId());

            return TokenDto.builder().type("Bearer ").token(token).build();
        } catch (Exception e) {
            throw new Error("Erro ao gerar Token " + e.getMessage());
        }
    }

}
