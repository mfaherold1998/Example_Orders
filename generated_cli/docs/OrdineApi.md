# OrdineApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteOrdine**](OrdineApi.md#deleteOrdine) | **DELETE** /api/ordini/{id} | Delete a ordine |
| [**getAllOrdini**](OrdineApi.md#getAllOrdini) | **GET** /api/ordini | Fetch all ordini |
| [**getOrdineById**](OrdineApi.md#getOrdineById) | **GET** /api/ordini/{id} | Fetch a ordine by Id |
| [**saveOrdine**](OrdineApi.md#saveOrdine) | **POST** /api/ordini | Adds a ordine |
| [**updateOrdine**](OrdineApi.md#updateOrdine) | **PUT** /api/ordini | Update a ordine |



## deleteOrdine

> deleteOrdine(id)

Delete a ordine

Delete a ordine by a specific id from the list of ordini in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdineApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdineApi apiInstance = new OrdineApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            apiInstance.deleteOrdine(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdineApi#deleteOrdine");
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
| **404** | there is not ordine with the given id |  -  |
| **202** | successfully deleted a ordine |  -  |


## getAllOrdini

> List&lt;OrdineDto&gt; getAllOrdini()

Fetch all ordini

Fetches all ordini entities and their data from data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdineApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdineApi apiInstance = new OrdineApi(defaultClient);
        try {
            List<OrdineDto> result = apiInstance.getAllOrdini();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdineApi#getAllOrdini");
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

[**List&lt;OrdineDto&gt;**](OrdineDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## getOrdineById

> OrdineDto getOrdineById(id)

Fetch a ordine by Id

Fetches a ordine entity and their data from data source by an specific Id

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdineApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdineApi apiInstance = new OrdineApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            OrdineDto result = apiInstance.getOrdineById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdineApi#getOrdineById");
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

[**OrdineDto**](OrdineDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## saveOrdine

> OrdineDto saveOrdine(ordineDto)

Adds a ordine

Adds a ordine to the list of ordini in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdineApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdineApi apiInstance = new OrdineApi(defaultClient);
        OrdineDto ordineDto = new OrdineDto(); // OrdineDto | 
        try {
            OrdineDto result = apiInstance.saveOrdine(ordineDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdineApi#saveOrdine");
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
| **ordineDto** | [**OrdineDto**](OrdineDto.md)|  | |

### Return type

[**OrdineDto**](OrdineDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | successfully added a ordine |  -  |
| **500** | invalid ordine cannot be added |  -  |


## updateOrdine

> OrdineDto updateOrdine(ordineDto)

Update a ordine

Update a ordine by a specific id from the list of ordini in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdineApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        OrdineApi apiInstance = new OrdineApi(defaultClient);
        OrdineDto ordineDto = new OrdineDto(); // OrdineDto | 
        try {
            OrdineDto result = apiInstance.updateOrdine(ordineDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdineApi#updateOrdine");
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
| **ordineDto** | [**OrdineDto**](OrdineDto.md)|  | |

### Return type

[**OrdineDto**](OrdineDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | there is not ordine with the given id |  -  |
| **200** | successfully updated a ordine |  -  |

