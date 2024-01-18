package securitySix;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Meu Spring Security", version = "0.0.1",
                description = "Api simples para cadastrar produtos e realizar pedidos, por autenticação via JWT."))
@SpringBootApplication
@ConfigurationPropertiesScan
public class SecuritySixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritySixApplication.class, args);
    }

}
