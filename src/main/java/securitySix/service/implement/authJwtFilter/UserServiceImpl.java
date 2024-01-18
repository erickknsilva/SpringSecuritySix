package securitySix.service.implement.authJwtFilter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import securitySix.domain.Authority;
import securitySix.domain.User;
import securitySix.dto.UserRequest;
import securitySix.dto.UserResponse;
import securitySix.repository.AuthorityRepository;
import securitySix.repository.UserRepository;
import securitySix.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;


    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserResponse createdUser(UserRequest request) {


        Optional<User> userOpt = userRepository.findByUsername(request.username());

        if (userOpt.isPresent()) {
            throw new Error("Usuario já existe");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder().encode(request.password()));


        user.setAuthorities(getAuthorities(request));
        userRepository.save(user);

        return UserResponse.builder()
                .username(user.getUsername())
                .authorities(getCollectAuthorities(user))
                .build();
    }

    private Set<Authority> getAuthorities(UserRequest request) {
        // Obtém as autoridades existentes com base nos IDs fornecidos
        Set<Long> authorityIds = request.authorityIds();
        return new HashSet<>(authorityRepository.findAllById(authorityIds));
    }

    private List<SimpleGrantedAuthority> getCollectAuthorities(User user) {
        return user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
    }


}
