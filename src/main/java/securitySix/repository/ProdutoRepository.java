package securitySix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySix.domain.Produto;

@Repository
public interface ProdutoRepository
        extends JpaRepository<Produto, Long> {

}
