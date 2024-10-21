package com.example.orders.controller;

import com.example.orders.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Product", description = "the Product Api")

public interface ProductApi {

    @Operation(
            summary = "Fetch all products",
            description = "Fetches all products entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<ProductDto>> getAllProducts();

    @Operation(
            summary = "Fetch a product by Id",
            description = "Fetches a product entity and their data from data source by an specific Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    @Operation(
            summary = "Adds a product",
            description = "Adds a product to the list of products in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added a product"),
            @ApiResponse(responseCode = "500", description = "invalid product cannot be added")
    })
    ResponseEntity<ProductDto> saveProduct (@RequestBody @Valid ProductDto productDto);

    @Operation(
            summary = "Delete a product",
            description = "Delete a product by a specific id from the list of products in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "successfully deleted a product"),
            @ApiResponse(responseCode = "404", description = "there is not product with the given id")
    })
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);

    @Operation(
            summary = "Update a product",
            description = "Update a product by a specific id from the list of products in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully updated a product"),
            @ApiResponse(responseCode = "404", description = "there is not product with the given id")
    })
    ResponseEntity<ProductDto> updateProduct (@RequestBody @Valid ProductDto productDto);

}
