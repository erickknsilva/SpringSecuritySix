package securitySix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "produtos")
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Defina o nome do produto.")
    private String nome;

    @NotBlank(message = "Insira a marca do produto.")
    private String marca;

    @NotNull(message = "o preço do produto deve ser definido.")
    @Positive(message = "O preço do produto deve ser maior que zero.")
    private BigDecimal preco;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Version
    private int version;

    public Produto(String nome, String marca, BigDecimal preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

}
