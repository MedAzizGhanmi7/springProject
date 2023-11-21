package tn.esprit.medazizg.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo") .description("TP étude de cas") .contact(contactAPI());
    }
    public Contact contactAPI() {
        return new Contact().name("Equipe ASIII").email("*************@esprit.tn").url("https://www.linkedin.com/in/**********/");
    }
/*
    @Bean
    public GroupedOpenApi productPublicApi() {return GroupedOpenApi.builder().group("Only Bloc ManagementAPI").pathsToMatch("api/blocs/**").pathsToExclude("**").build();

    }*/
}
