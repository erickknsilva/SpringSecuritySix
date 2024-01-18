package securitySix.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String generatedToken(Long userId);

    Boolean isValid(String token);

    Long getUserId(String token);


}
