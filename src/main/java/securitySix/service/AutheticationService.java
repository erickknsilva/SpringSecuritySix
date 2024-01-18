package securitySix.service;

import securitySix.dto.LoginRequest;
import securitySix.dto.TokenDto;

public interface AutheticationService {

    TokenDto authentication(LoginRequest request);
}
