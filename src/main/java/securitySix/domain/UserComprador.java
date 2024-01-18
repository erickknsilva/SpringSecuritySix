package securitySix.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user_comprador")
@EntityListeners(AuditingEntityListener.class)
public class UserComprador {

    @Id
    private Long id;

    private String email;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Version
    private int version;

    public UserComprador(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
