package securitySix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import securitySix.domain.Pedido;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {


    @Query("SELECT DISTINCT p " +
            "FROM pedidos p " +
            "JOIN FETCH p.produtos produtos " +
            "JOIN FETCH p.userComprador uc " +
            "WHERE uc.id = :userId")
    List<Pedido> findAll(@Param("userId") Long userId);


    @Query("SELECT DISTINCT p " +
            "FROM pedidos p " +
            "JOIN FETCH p.produtos produtos " +
            "JOIN FETCH p.userComprador uc " +
            "WHERE p.id = :pedidoId AND uc.id = :userId")
    Optional<Pedido> findById(@Param("pedidoId") Long pedidoId, @Param("userId") Long userId);


}
