package securitySix.service.implement.authJwtFilter;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import securitySix.domain.User;
import securitySix.repository.UserRepository;
import securitySix.service.UserDetailsServiceTwo;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl2 implements UserDetailsServiceTwo {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loadUserByUsername(String username, String password) throws UsernameNotFoundException {

        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            throw new Error("Usuário não encontrado.");
        }

        if (checkPassword(password, userOpt.get().getPassword())) {
            return userOpt.get();

        }

        throw new Error("Senha invalida");
    }


    public Boolean checkPassword(String password, String passwordLogin) {
        return passwordEncoder().matches(password, passwordLogin);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
