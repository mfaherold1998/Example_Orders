package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.BillDto;

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
public class BillApi {
    private ApiClient apiClient;

    public BillApi() {
        this(new ApiClient());
    }

    @Autowired
    public BillApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a bill
     * Delete a bill by a specific id from the list of bills in the data source
     * <p><b>202</b> - successfully deleted a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteBillRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling deleteBill", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/api/bills/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a bill
     * Delete a bill by a specific id from the list of bills in the data source
     * <p><b>202</b> - successfully deleted a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteBill(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteBillRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a bill
     * Delete a bill by a specific id from the list of bills in the data source
     * <p><b>202</b> - successfully deleted a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param id The id parameter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteBillWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteBillRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a bill
     * Delete a bill by a specific id from the list of bills in the data source
     * <p><b>202</b> - successfully deleted a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteBillWithResponseSpec(Long id) throws WebClientResponseException {
        return deleteBillRequestCreation(id);
    }
    /**
     * Fetch all bills
     * Fetches all bills entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;BillDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAllBillsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return apiClient.invokeAPI("/api/bills", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch all bills
     * Fetches all bills entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return List&lt;BillDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<BillDto> getAllBills() throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return getAllBillsRequestCreation().bodyToFlux(localVarReturnType);
    }

    /**
     * Fetch all bills
     * Fetches all bills entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseEntity&lt;List&lt;BillDto&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<BillDto>>> getAllBillsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return getAllBillsRequestCreation().toEntityList(localVarReturnType);
    }

    /**
     * Fetch all bills
     * Fetches all bills entities and their data from data source
     * <p><b>200</b> - successful operation
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAllBillsWithResponseSpec() throws WebClientResponseException {
        return getAllBillsRequestCreation();
    }
    /**
     * Fetch a bill by Id
     * Fetches a bill entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return BillDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getBillByIdRequestCreation(Long id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getBillById", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return apiClient.invokeAPI("/api/bills/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Fetch a bill by Id
     * Fetches a bill entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return BillDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<BillDto> getBillById(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return getBillByIdRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Fetch a bill by Id
     * Fetches a bill entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseEntity&lt;BillDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<BillDto>> getBillByIdWithHttpInfo(Long id) throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return getBillByIdRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Fetch a bill by Id
     * Fetches a bill entity and their data from data source by an specific Id
     * <p><b>200</b> - successful operation
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getBillByIdWithResponseSpec(Long id) throws WebClientResponseException {
        return getBillByIdRequestCreation(id);
    }
    /**
     * Adds a bill
     * Adds a bill to the list of bills in the data source
     * <p><b>500</b> - invalid bill cannot be added
     * <p><b>201</b> - successfully added a bill
     * @param billDto The billDto parameter
     * @return BillDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec saveBillRequestCreation(BillDto billDto) throws WebClientResponseException {
        Object postBody = billDto;
        // verify the required parameter 'billDto' is set
        if (billDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'billDto' when calling saveBill", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return apiClient.invokeAPI("/api/bills", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Adds a bill
     * Adds a bill to the list of bills in the data source
     * <p><b>500</b> - invalid bill cannot be added
     * <p><b>201</b> - successfully added a bill
     * @param billDto The billDto parameter
     * @return BillDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<BillDto> saveBill(BillDto billDto) throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return saveBillRequestCreation(billDto).bodyToMono(localVarReturnType);
    }

    /**
     * Adds a bill
     * Adds a bill to the list of bills in the data source
     * <p><b>500</b> - invalid bill cannot be added
     * <p><b>201</b> - successfully added a bill
     * @param billDto The billDto parameter
     * @return ResponseEntity&lt;BillDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<BillDto>> saveBillWithHttpInfo(BillDto billDto) throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return saveBillRequestCreation(billDto).toEntity(localVarReturnType);
    }

    /**
     * Adds a bill
     * Adds a bill to the list of bills in the data source
     * <p><b>500</b> - invalid bill cannot be added
     * <p><b>201</b> - successfully added a bill
     * @param billDto The billDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec saveBillWithResponseSpec(BillDto billDto) throws WebClientResponseException {
        return saveBillRequestCreation(billDto);
    }
    /**
     * Update a bill
     * Update a bill by a specific id from the list of bills in the data source
     * <p><b>200</b> - successfully updated a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param billDto The billDto parameter
     * @return BillDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateBillRequestCreation(BillDto billDto) throws WebClientResponseException {
        Object postBody = billDto;
        // verify the required parameter 'billDto' is set
        if (billDto == null) {
            throw new WebClientResponseException("Missing the required parameter 'billDto' when calling updateBill", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return apiClient.invokeAPI("/api/bills", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a bill
     * Update a bill by a specific id from the list of bills in the data source
     * <p><b>200</b> - successfully updated a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param billDto The billDto parameter
     * @return BillDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<BillDto> updateBill(BillDto billDto) throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return updateBillRequestCreation(billDto).bodyToMono(localVarReturnType);
    }

    /**
     * Update a bill
     * Update a bill by a specific id from the list of bills in the data source
     * <p><b>200</b> - successfully updated a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param billDto The billDto parameter
     * @return ResponseEntity&lt;BillDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<BillDto>> updateBillWithHttpInfo(BillDto billDto) throws WebClientResponseException {
        ParameterizedTypeReference<BillDto> localVarReturnType = new ParameterizedTypeReference<BillDto>() {};
        return updateBillRequestCreation(billDto).toEntity(localVarReturnType);
    }

    /**
     * Update a bill
     * Update a bill by a specific id from the list of bills in the data source
     * <p><b>200</b> - successfully updated a bill
     * <p><b>404</b> - there is not bill with the given id
     * @param billDto The billDto parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateBillWithResponseSpec(BillDto billDto) throws WebClientResponseException {
        return updateBillRequestCreation(billDto);
    }
}
