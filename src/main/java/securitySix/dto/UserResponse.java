package securitySix.dto;

import lombok.Builder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Builder(toBuilder = true)
public record UserResponse(
        String username,
        List<SimpleGrantedAuthority> authorities) {
}
