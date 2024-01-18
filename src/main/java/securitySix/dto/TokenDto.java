package securitySix.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record TokenDto(String type,
                       String token) {
}
