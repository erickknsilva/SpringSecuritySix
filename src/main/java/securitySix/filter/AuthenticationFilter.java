package securitySix.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import securitySix.domain.User;
import securitySix.repository.UserRepository;
import securitySix.service.TokenService;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class AuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    public AuthenticationFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = getBearerToken(request);

        if (tokenService.isValid(token)) {
            authenticationByToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticationByToken(String token) {

        Optional<User> userOpt = userRepository
                .findById(tokenService.getUserId(token));

        if (userOpt.isEmpty()) {
            throw new Error("Usuario não encontrado.");
        }

        authenticateUser(userOpt.get());
    }

    private void authenticateUser(User user) {

        UsernamePasswordAuthenticationToken userAuth =
                new UsernamePasswordAuthenticationToken
                        (user, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(userAuth);
    }


    private String getBearerToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if (Objects.isNull(token) || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.replace("Bearer ", "");
    }

}
