package securitySix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySix.domain.Authority;

@Repository
public interface AuthorityRepository
        extends JpaRepository<Authority, Long> {

}
