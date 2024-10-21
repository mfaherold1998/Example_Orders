/*package com.example.orders.Configuration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.BillApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiClientConfig {

    @Bean
    public ApiClient apiClient() {
        ApiClient client = new ApiClient();
        client.setBasePath("https://api-url.com");  // Configura la URL base de tu API
        // Configura autenticación u otros ajustes si es necesario
        // client.setBearerToken("tu_token_de_autenticacion");
        return client;
    }

    @Bean
    public BillApi billApi(ApiClient apiClient) {
        return new BillApi(apiClient);
    }
    //Una vez configurado como bean se puede inyectar en el servicio o en el controller como se necesite

}*/