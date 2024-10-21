package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ClientDto;

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
public class ClientApi {
    private ApiClient apiClient;

    public ClientApi() {
        this(new ApiClient());
    }

    @Autowired
    public ClientApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a client
     * Delete a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>202</b> - successfully deleted a client
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteClientRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling deleteClient", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/api/clients/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a client
     * Delete a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>202</b> - successfully deleted a client
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteClient(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteClientRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a client
     * Delete a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>202</b> - successfully deleted a client
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteClientWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteClientRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a client
     * Delete a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>202</b> - successfully deleted a client
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteClientWithResponseSpec(Long id) throws WebClientResponseException {
        return deleteClientRequestCreation(id);
    }
    /**
     * Fetch all clients
     * Fetches all clients entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;ClientDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAllClientsRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return apiClient.invokeAPI("/api/clients", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch all clients
     * Fetches all clients entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;ClientDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<ClientDto> getAllClients() throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return getAllClientsRequestCreation().bodyToFlux(localVarReturnType);
    }

    /**
     * Fetch all clients
     * Fetches all clients entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseEntity&lt;List&lt;ClientDto&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<ClientDto>>> getAllClientsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return getAllClientsRequestCreation().toEntityList(localVarReturnType);
    }

    /**
     * Fetch all clients
     * Fetches all clients entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAllClientsWithResponseSpec() throws WebClientResponseException {
        return getAllClientsRequestCreation();
    }
    /**
     * Fetch a client by Id
     * Fetches a client entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ClientDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getClientByIdRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getClientById", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return apiClient.invokeAPI("/api/clients/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch a client by Id
     * Fetches a client entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ClientDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ClientDto> getClientById(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return getClientByIdRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Fetch a client by Id
     * Fetches a client entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseEntity&lt;ClientDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ClientDto>> getClientByIdWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return getClientByIdRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Fetch a client by Id
     * Fetches a client entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getClientByIdWithResponseSpec(Long id) throws WebClientResponseException {
        return getClientByIdRequestCreation(id);
    }
    /**
     * Adds a client
     * Adds a client to the list of clients in the data source
     * <p><b>201</b> - successfully added a client
     * <p><b>500</b> - invalid client cannot be added
     * @param clientDto The clientDto parameter
     * @return ClientDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec saveClientRequestCreation(ClientDto clientDto) throws WebClientResponseException {
        Object postBody = clientDto;
        // verify the required parameter 'clientDto' is set
        if (clientDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'clientDto' when calling saveClient", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return apiClient.invokeAPI("/api/clients", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Adds a client
     * Adds a client to the list of clients in the data source
     * <p><b>201</b> - successfully added a client
     * <p><b>500</b> - invalid client cannot be added
     * @param clientDto The clientDto parameter
     * @return ClientDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ClientDto> saveClient(ClientDto clientDto) throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return saveClientRequestCreation(clientDto).bodyToMono(localVarReturnType);
    }

    /**
     * Adds a client
     * Adds a client to the list of clients in the data source
     * <p><b>201</b> - successfully added a client
     * <p><b>500</b> - invalid client cannot be added
     * @param clientDto The clientDto parameter
     * @return ResponseEntity&lt;ClientDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ClientDto>> saveClientWithHttpInfo(ClientDto clientDto) throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return saveClientRequestCreation(clientDto).toEntity(localVarReturnType);
    }

    /**
     * Adds a client
     * Adds a client to the list of clients in the data source
     * <p><b>201</b> - successfully added a client
     * <p><b>500</b> - invalid client cannot be added
     * @param clientDto The clientDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec saveClientWithResponseSpec(ClientDto clientDto) throws WebClientResponseException {
        return saveClientRequestCreation(clientDto);
    }
    /**
     * Update a client
     * Update a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>200</b> - successfully updated a client
     * @param clientDto The clientDto parameter
     * @return ClientDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateClientRequestCreation(ClientDto clientDto) throws WebClientResponseException {
        Object postBody = clientDto;
        // verify the required parameter 'clientDto' is set
        if (clientDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'clientDto' when calling updateClient", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return apiClient.invokeAPI("/api/clients", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a client
     * Update a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>200</b> - successfully updated a client
     * @param clientDto The clientDto parameter
     * @return ClientDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ClientDto> updateClient(ClientDto clientDto) throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return updateClientRequestCreation(clientDto).bodyToMono(localVarReturnType);
    }

    /**
     * Update a client
     * Update a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>200</b> - successfully updated a client
     * @param clientDto The clientDto parameter
     * @return ResponseEntity&lt;ClientDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ClientDto>> updateClientWithHttpInfo(ClientDto clientDto) throws WebClientResponseException {
        ParameterizedTypeReference<ClientDto> localVarReturnType = new ParameterizedTypeReference<ClientDto>() {};
        return updateClientRequestCreation(clientDto).toEntity(localVarReturnType);
    }

    /**
     * Update a client
     * Update a client by a specific id from the list of clients in the data source
     * <p><b>404</b> - there is not client with the given id
     * <p><b>200</b> - successfully updated a client
     * @param clientDto The clientDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateClientWithResponseSpec(ClientDto clientDto) throws WebClientResponseException {
        return updateClientRequestCreation(clientDto);
    }
}
