package com.example.orders;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OnlineOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineOrdersApplication.class, args);
		log.info("App is started!");
	}

}

//url para ver el swagger: http://localhost:8080/swagger-ui/index.html#/
//url para la documentacion en json: http://localhost:8080/api-docs
//comando para generar un cliente automatico usando docker: docker run --rm -v C:\Users\hp\Documents\!Work\pegasoft\SpringBootCode\orders:/local openapitools/openapi-generator-cli generate -i /local/openapi.json -g java -o /local/generated_cli --additional-properties=library=okhttp --additional-properties=library=spring-boot
//generar documentacion html: docker run --rm -v C:\Users\hp\Documents\!Work\pegasoft\SpringBootCode\orders:/local openapitools/openapi-generator-cli generate -i /local/openapi.json -g html2 -o local/output
//pdf: asciidoc