/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.model.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API tests for ProductApi
 */
@Disabled
public class ProductApiTest {

    private final ProductApi api = new ProductApi();

    
    /**
     * Delete a product
     *
     * Delete a product by a specific id from the list of products in the data source
     */
    @Test
    public void deleteProductTest()  {
        // uncomment below to test the function
        //Long id = null;
        //api.deleteProduct(id).block();

        // TODO: test validations
    }
    
    /**
     * Fetch all products
     *
     * Fetches all products entities and their data from data source
     */
    @Test
    public void getAllProductsTest()  {
        // uncomment below to test the function
        //List<ProductDto> response = api.getAllProducts().collectList().block();

        // TODO: test validations
    }
    
    /**
     * Fetch a product by Id
     *
     * Fetches a product entity and their data from data source by an specific Id
     */
    @Test
    public void getProductByIdTest()  {
        // uncomment below to test the function
        //Long id = null;
        //ProductDto response = api.getProductById(id).block();

        // TODO: test validations
    }
    
    /**
     * Adds a product
     *
     * Adds a product to the list of products in the data source
     */
    @Test
    public void saveProductTest()  {
        // uncomment below to test the function
        //ProductDto productDto = null;
        //ProductDto response = api.saveProduct(productDto).block();

        // TODO: test validations
    }
    
    /**
     * Update a product
     *
     * Update a product by a specific id from the list of products in the data source
     */
    @Test
    public void updateProductTest()  {
        // uncomment below to test the function
        //ProductDto productDto = null;
        //ProductDto response = api.updateProduct(productDto).block();

        // TODO: test validations
    }
    
}
