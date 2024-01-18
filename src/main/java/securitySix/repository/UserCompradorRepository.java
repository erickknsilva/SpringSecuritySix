package securitySix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySix.domain.UserComprador;

import java.util.Optional;

@Repository
public interface UserCompradorRepository
        extends JpaRepository<UserComprador, Long> {

    Optional<UserComprador> findByEmail(String email);

}
