# ClientApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteClient**](ClientApi.md#deleteClient) | **DELETE** /api/clients/{id} | Delete a client |
| [**getAllClients**](ClientApi.md#getAllClients) | **GET** /api/clients | Fetch all clients |
| [**getClientById**](ClientApi.md#getClientById) | **GET** /api/clients/{id} | Fetch a client by Id |
| [**saveClient**](ClientApi.md#saveClient) | **POST** /api/clients | Adds a client |
| [**updateClient**](ClientApi.md#updateClient) | **PUT** /api/clients | Update a client |



## deleteClient

> deleteClient(id)

Delete a client

Delete a client by a specific id from the list of clients in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ClientApi apiInstance = new ClientApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            apiInstance.deleteClient(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ClientApi#deleteClient");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | there is not client with the given id |  -  |
| **202** | successfully deleted a client |  -  |


## getAllClients

> List&lt;ClientDto&gt; getAllClients()

Fetch all clients

Fetches all clients entities and their data from data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ClientApi apiInstance = new ClientApi(defaultClient);
        try {
            List<ClientDto> result = apiInstance.getAllClients();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ClientApi#getAllClients");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;ClientDto&gt;**](ClientDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## getClientById

> ClientDto getClientById(id)

Fetch a client by Id

Fetches a client entity and their data from data source by an specific Id

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ClientApi apiInstance = new ClientApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            ClientDto result = apiInstance.getClientById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ClientApi#getClientById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**|  | |

### Return type

[**ClientDto**](ClientDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## saveClient

> ClientDto saveClient(clientDto)

Adds a client

Adds a client to the list of clients in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ClientApi apiInstance = new ClientApi(defaultClient);
        ClientDto clientDto = new ClientDto(); // ClientDto | 
        try {
            ClientDto result = apiInstance.saveClient(clientDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ClientApi#saveClient");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **clientDto** | [**ClientDto**](ClientDto.md)|  | |

### Return type

[**ClientDto**](ClientDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | successfully added a client |  -  |
| **500** | invalid client cannot be added |  -  |


## updateClient

> ClientDto updateClient(clientDto)

Update a client

Update a client by a specific id from the list of clients in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ClientApi apiInstance = new ClientApi(defaultClient);
        ClientDto clientDto = new ClientDto(); // ClientDto | 
        try {
            ClientDto result = apiInstance.updateClient(clientDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ClientApi#updateClient");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **clientDto** | [**ClientDto**](ClientDto.md)|  | |

### Return type

[**ClientDto**](ClientDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | there is not client with the given id |  -  |
| **200** | successfully updated a client |  -  |

