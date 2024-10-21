package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ProductDto;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-18T14:37:22.823946236Z[Etc/UTC]", comments = "Generator version: 7.10.0-SNAPSHOT")
public class ProductApi {
    private ApiClient apiClient;

    public ProductApi() {
        this(new ApiClient());
    }

    @Autowired
    public ProductApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a product
     * Delete a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>202</b> - successfully deleted a product
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteProductRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling deleteProduct", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/api/products/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a product
     * Delete a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>202</b> - successfully deleted a product
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteProduct(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteProductRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a product
     * Delete a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>202</b> - successfully deleted a product
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteProductWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteProductRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a product
     * Delete a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>202</b> - successfully deleted a product
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteProductWithResponseSpec(Long id) throws WebClientResponseException {
        return deleteProductRequestCreation(id);
    }
    /**
     * Fetch all products
     * Fetches all products entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;ProductDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAllProductsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/api/products", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch all products
     * Fetches all products entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;ProductDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<ProductDto> getAllProducts() throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return getAllProductsRequestCreation().bodyToFlux(localVarReturnType);
    }

    /**
     * Fetch all products
     * Fetches all products entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseEntity&lt;List&lt;ProductDto&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<ProductDto>>> getAllProductsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return getAllProductsRequestCreation().toEntityList(localVarReturnType);
    }

    /**
     * Fetch all products
     * Fetches all products entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAllProductsWithResponseSpec() throws WebClientResponseException {
        return getAllProductsRequestCreation();
    }
    /**
     * Fetch a product by Id
     * Fetches a product entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ProductDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getProductByIdRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getProductById", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/api/products/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch a product by Id
     * Fetches a product entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ProductDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ProductDto> getProductById(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return getProductByIdRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Fetch a product by Id
     * Fetches a product entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseEntity&lt;ProductDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ProductDto>> getProductByIdWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return getProductByIdRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Fetch a product by Id
     * Fetches a product entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getProductByIdWithResponseSpec(Long id) throws WebClientResponseException {
        return getProductByIdRequestCreation(id);
    }
    /**
     * Adds a product
     * Adds a product to the list of products in the data source
     * <p><b>500</b> - invalid product cannot be added
     * <p><b>201</b> - successfully added a product
     * @param productDto The productDto parameter
     * @return ProductDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec saveProductRequestCreation(ProductDto productDto) throws WebClientResponseException {
        Object postBody = productDto;
        // verify the required parameter 'productDto' is set
        if (productDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'productDto' when calling saveProduct", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/api/products", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Adds a product
     * Adds a product to the list of products in the data source
     * <p><b>500</b> - invalid product cannot be added
     * <p><b>201</b> - successfully added a product
     * @param productDto The productDto parameter
     * @return ProductDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ProductDto> saveProduct(ProductDto productDto) throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return saveProductRequestCreation(productDto).bodyToMono(localVarReturnType);
    }

    /**
     * Adds a product
     * Adds a product to the list of products in the data source
     * <p><b>500</b> - invalid product cannot be added
     * <p><b>201</b> - successfully added a product
     * @param productDto The productDto parameter
     * @return ResponseEntity&lt;ProductDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ProductDto>> saveProductWithHttpInfo(ProductDto productDto) throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return saveProductRequestCreation(productDto).toEntity(localVarReturnType);
    }

    /**
     * Adds a product
     * Adds a product to the list of products in the data source
     * <p><b>500</b> - invalid product cannot be added
     * <p><b>201</b> - successfully added a product
     * @param productDto The productDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec saveProductWithResponseSpec(ProductDto productDto) throws WebClientResponseException {
        return saveProductRequestCreation(productDto);
    }
    /**
     * Update a product
     * Update a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>200</b> - successfully updated a product
     * @param productDto The productDto parameter
     * @return ProductDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateProductRequestCreation(ProductDto productDto) throws WebClientResponseException {
        Object postBody = productDto;
        // verify the required parameter 'productDto' is set
        if (productDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'productDto' when calling updateProduct", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/api/products", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a product
     * Update a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>200</b> - successfully updated a product
     * @param productDto The productDto parameter
     * @return ProductDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ProductDto> updateProduct(ProductDto productDto) throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return updateProductRequestCreation(productDto).bodyToMono(localVarReturnType);
    }

    /**
     * Update a product
     * Update a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>200</b> - successfully updated a product
     * @param productDto The productDto parameter
     * @return ResponseEntity&lt;ProductDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ProductDto>> updateProductWithHttpInfo(ProductDto productDto) throws WebClientResponseException {
        ParameterizedTypeReference<ProductDto> localVarReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return updateProductRequestCreation(productDto).toEntity(localVarReturnType);
    }

    /**
     * Update a product
     * Update a product by a specific id from the list of products in the data source
     * <p><b>404</b> - there is not product with the given id
     * <p><b>200</b> - successfully updated a product
     * @param productDto The productDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateProductWithResponseSpec(ProductDto productDto) throws WebClientResponseException {
        return updateProductRequestCreation(productDto);
    }
}
