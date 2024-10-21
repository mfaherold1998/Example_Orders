package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.OrdineDto;

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
public class OrdineApi {
    private ApiClient apiClient;

    public OrdineApi() {
        this(new ApiClient());
    }

    @Autowired
    public OrdineApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a ordine
     * Delete a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>202</b> - successfully deleted a ordine
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteOrdineRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling deleteOrdine", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/api/ordini/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a ordine
     * Delete a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>202</b> - successfully deleted a ordine
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteOrdine(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteOrdineRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a ordine
     * Delete a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>202</b> - successfully deleted a ordine
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteOrdineWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteOrdineRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a ordine
     * Delete a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>202</b> - successfully deleted a ordine
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteOrdineWithResponseSpec(Long id) throws WebClientResponseException {
        return deleteOrdineRequestCreation(id);
    }
    /**
     * Fetch all ordini
     * Fetches all ordini entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;OrdineDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAllOrdiniRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return apiClient.invokeAPI("/api/ordini", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch all ordini
     * Fetches all ordini entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;OrdineDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<OrdineDto> getAllOrdini() throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return getAllOrdiniRequestCreation().bodyToFlux(localVarReturnType);
    }

    /**
     * Fetch all ordini
     * Fetches all ordini entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseEntity&lt;List&lt;OrdineDto&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<OrdineDto>>> getAllOrdiniWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return getAllOrdiniRequestCreation().toEntityList(localVarReturnType);
    }

    /**
     * Fetch all ordini
     * Fetches all ordini entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAllOrdiniWithResponseSpec() throws WebClientResponseException {
        return getAllOrdiniRequestCreation();
    }
    /**
     * Fetch a ordine by Id
     * Fetches a ordine entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return OrdineDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getOrdineByIdRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getOrdineById", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return apiClient.invokeAPI("/api/ordini/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch a ordine by Id
     * Fetches a ordine entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return OrdineDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OrdineDto> getOrdineById(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return getOrdineByIdRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Fetch a ordine by Id
     * Fetches a ordine entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseEntity&lt;OrdineDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OrdineDto>> getOrdineByIdWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return getOrdineByIdRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Fetch a ordine by Id
     * Fetches a ordine entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getOrdineByIdWithResponseSpec(Long id) throws WebClientResponseException {
        return getOrdineByIdRequestCreation(id);
    }
    /**
     * Adds a ordine
     * Adds a ordine to the list of ordini in the data source
     * <p><b>201</b> - successfully added a ordine
     * <p><b>500</b> - invalid ordine cannot be added
     * @param ordineDto The ordineDto parameter
     * @return OrdineDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec saveOrdineRequestCreation(OrdineDto ordineDto) throws WebClientResponseException {
        Object postBody = ordineDto;
        // verify the required parameter 'ordineDto' is set
        if (ordineDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'ordineDto' when calling saveOrdine", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return apiClient.invokeAPI("/api/ordini", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Adds a ordine
     * Adds a ordine to the list of ordini in the data source
     * <p><b>201</b> - successfully added a ordine
     * <p><b>500</b> - invalid ordine cannot be added
     * @param ordineDto The ordineDto parameter
     * @return OrdineDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OrdineDto> saveOrdine(OrdineDto ordineDto) throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return saveOrdineRequestCreation(ordineDto).bodyToMono(localVarReturnType);
    }

    /**
     * Adds a ordine
     * Adds a ordine to the list of ordini in the data source
     * <p><b>201</b> - successfully added a ordine
     * <p><b>500</b> - invalid ordine cannot be added
     * @param ordineDto The ordineDto parameter
     * @return ResponseEntity&lt;OrdineDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OrdineDto>> saveOrdineWithHttpInfo(OrdineDto ordineDto) throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return saveOrdineRequestCreation(ordineDto).toEntity(localVarReturnType);
    }

    /**
     * Adds a ordine
     * Adds a ordine to the list of ordini in the data source
     * <p><b>201</b> - successfully added a ordine
     * <p><b>500</b> - invalid ordine cannot be added
     * @param ordineDto The ordineDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec saveOrdineWithResponseSpec(OrdineDto ordineDto) throws WebClientResponseException {
        return saveOrdineRequestCreation(ordineDto);
    }
    /**
     * Update a ordine
     * Update a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>200</b> - successfully updated a ordine
     * @param ordineDto The ordineDto parameter
     * @return OrdineDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateOrdineRequestCreation(OrdineDto ordineDto) throws WebClientResponseException {
        Object postBody = ordineDto;
        // verify the required parameter 'ordineDto' is set
        if (ordineDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'ordineDto' when calling updateOrdine", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return apiClient.invokeAPI("/api/ordini", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a ordine
     * Update a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>200</b> - successfully updated a ordine
     * @param ordineDto The ordineDto parameter
     * @return OrdineDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OrdineDto> updateOrdine(OrdineDto ordineDto) throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return updateOrdineRequestCreation(ordineDto).bodyToMono(localVarReturnType);
    }

    /**
     * Update a ordine
     * Update a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>200</b> - successfully updated a ordine
     * @param ordineDto The ordineDto parameter
     * @return ResponseEntity&lt;OrdineDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<OrdineDto>> updateOrdineWithHttpInfo(OrdineDto ordineDto) throws WebClientResponseException {
        ParameterizedTypeReference<OrdineDto> localVarReturnType = new ParameterizedTypeReference<OrdineDto>() {};
        return updateOrdineRequestCreation(ordineDto).toEntity(localVarReturnType);
    }

    /**
     * Update a ordine
     * Update a ordine by a specific id from the list of ordini in the data source
     * <p><b>404</b> - there is not ordine with the given id
     * <p><b>200</b> - successfully updated a ordine
     * @param ordineDto The ordineDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateOrdineWithResponseSpec(OrdineDto ordineDto) throws WebClientResponseException {
        return updateOrdineRequestCreation(ordineDto);
    }
}
