package securitySix.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import securitySix.domain.User;

public interface UserDetailsServiceTwo {

    User loadUserByUsername(String username, String password) throws UsernameNotFoundException;

}
