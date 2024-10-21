# BillApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteBill**](BillApi.md#deleteBill) | **DELETE** /api/bills/{id} | Delete a bill |
| [**getAllBills**](BillApi.md#getAllBills) | **GET** /api/bills | Fetch all bills |
| [**getBillById**](BillApi.md#getBillById) | **GET** /api/bills/{id} | Fetch a bill by Id |
| [**saveBill**](BillApi.md#saveBill) | **POST** /api/bills | Adds a bill |
| [**updateBill**](BillApi.md#updateBill) | **PUT** /api/bills | Update a bill |



## deleteBill

> deleteBill(id)

Delete a bill

Delete a bill by a specific id from the list of bills in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BillApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BillApi apiInstance = new BillApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            apiInstance.deleteBill(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling BillApi#deleteBill");
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
| **202** | successfully deleted a bill |  -  |
| **404** | there is not bill with the given id |  -  |


## getAllBills

> List&lt;BillDto&gt; getAllBills()

Fetch all bills

Fetches all bills entities and their data from data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BillApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BillApi apiInstance = new BillApi(defaultClient);
        try {
            List<BillDto> result = apiInstance.getAllBills();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BillApi#getAllBills");
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

[**List&lt;BillDto&gt;**](BillDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## getBillById

> BillDto getBillById(id)

Fetch a bill by Id

Fetches a bill entity and their data from data source by an specific Id

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BillApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BillApi apiInstance = new BillApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            BillDto result = apiInstance.getBillById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BillApi#getBillById");
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

[**BillDto**](BillDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |


## saveBill

> BillDto saveBill(billDto)

Adds a bill

Adds a bill to the list of bills in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BillApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BillApi apiInstance = new BillApi(defaultClient);
        BillDto billDto = new BillDto(); // BillDto | 
        try {
            BillDto result = apiInstance.saveBill(billDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BillApi#saveBill");
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
| **billDto** | [**BillDto**](BillDto.md)|  | |

### Return type

[**BillDto**](BillDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | invalid bill cannot be added |  -  |
| **201** | successfully added a bill |  -  |


## updateBill

> BillDto updateBill(billDto)

Update a bill

Update a bill by a specific id from the list of bills in the data source

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BillApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        BillApi apiInstance = new BillApi(defaultClient);
        BillDto billDto = new BillDto(); // BillDto | 
        try {
            BillDto result = apiInstance.updateBill(billDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BillApi#updateBill");
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
| **billDto** | [**BillDto**](BillDto.md)|  | |

### Return type

[**BillDto**](BillDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successfully updated a bill |  -  |
| **404** | there is not bill with the given id |  -  |

