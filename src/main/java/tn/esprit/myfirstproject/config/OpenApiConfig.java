package tn.esprit.myfirstproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ghassen Chamakh",
                        email = "ghassen.chamakh@esprit.tn"
                ),
                title = "Gestion Foyer",
                version = "2.0.0",
                description = "SWAGGER : Gestion Foyer"
        )
)
public class OpenApiConfig {
}
