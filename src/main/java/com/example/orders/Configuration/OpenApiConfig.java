package com.example.orders.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Mi API",
                version = "1.0.0",
                description = "Descripción de mi API con versiones"
        ),
        servers = {
                @Server(url = "https://v1/api", description = "Servidor de Producción v1"),
                @Server(url = "https://v2/api", description = "Servidor de Producción v2")
        }
)
public class OpenApiConfig {
    // Configuraciones adicionales si son necesarias
}
