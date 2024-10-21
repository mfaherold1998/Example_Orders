# ProductApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteProduct**](ProductApi.md#deleteProduct) | **DELETE** /api/products/{id} | Delete a product |
| [**getAllProducts**](ProductApi.md#getAllProducts) | **GET** /api/products | Fetch all products |
| [**getProductById**](ProductApi.md#getProductById) | **GET** /api/products/{id} | Fetch a product by Id |
| [**saveProduct**](ProductApi.md#saveProduct) | **POST** /api/products | Adds a product |
| [**updateProduct**](ProductApi.md#updateProduct) | **PUT** /api/products | Update a product |



## deleteProduct

> deleteProduct(id)

Delete a product

Delete a product by a specific id from the list of products in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ProductApi apiInstance = new ProductApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            apiInstance.deleteProduct(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductApi#deleteProduct");
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
| **404** | there is not product with the given id |  -  |
| **202** | successfully deleted a product |  -  |


## getAllProducts

> List&lt;ProductDto&gt; getAllProducts()

Fetch all products

Fetches all products entities and their data from data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ProductApi apiInstance = new ProductApi(defaultClient);
        try {
            List<ProductDto> result = apiInstance.getAllProducts();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductApi#getAllProducts");
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

[**List&lt;ProductDto&gt;**](ProductDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## getProductById

> ProductDto getProductById(id)

Fetch a product by Id

Fetches a product entity and their data from data source by an specific Id

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ProductApi apiInstance = new ProductApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            ProductDto result = apiInstance.getProductById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductApi#getProductById");
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

[**ProductDto**](ProductDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## saveProduct

> ProductDto saveProduct(productDto)

Adds a product

Adds a product to the list of products in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ProductApi apiInstance = new ProductApi(defaultClient);
        ProductDto productDto = new ProductDto(); // ProductDto | 
        try {
            ProductDto result = apiInstance.saveProduct(productDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductApi#saveProduct");
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
| **productDto** | [**ProductDto**](ProductDto.md)|  | |

### Return type

[**ProductDto**](ProductDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | invalid product cannot be added |  -  |
| **201** | successfully added a product |  -  |


## updateProduct

> ProductDto updateProduct(productDto)

Update a product

Update a product by a specific id from the list of products in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProductApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ProductApi apiInstance = new ProductApi(defaultClient);
        ProductDto productDto = new ProductDto(); // ProductDto | 
        try {
            ProductDto result = apiInstance.updateProduct(productDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductApi#updateProduct");
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
| **productDto** | [**ProductDto**](ProductDto.md)|  | |

### Return type

[**ProductDto**](ProductDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | there is not product with the given id |  -  |
| **200** | successfully updated a product |  -  |

