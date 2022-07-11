package com.polyanin.sms.settings;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info
    (title = "SMS", description = "Staff Management Service", version = "1.0",
        contact = @Contact(name = "Daniil", email = "polyanin.daniil@yandex.ru")))
public class SwaggerConfig {

}
