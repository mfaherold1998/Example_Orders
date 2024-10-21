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

import org.openapitools.client.model.BillDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API tests for BillApi
 */
@Disabled
public class BillApiTest {

    private final BillApi api = new BillApi();

    
    /**
     * Delete a bill
     *
     * Delete a bill by a specific id from the list of bills in the data source
     */
    @Test
    public void deleteBillTest()  {
        // uncomment below to test the function
        //Long id = null;
        //api.deleteBill(id).block();

        // TODO: test validations
    }
    
    /**
     * Fetch all bills
     *
     * Fetches all bills entities and their data from data source
     */
    @Test
    public void getAllBillsTest()  {
        // uncomment below to test the function
        //List<BillDto> response = api.getAllBills().collectList().block();

        // TODO: test validations
    }
    
    /**
     * Fetch a bill by Id
     *
     * Fetches a bill entity and their data from data source by an specific Id
     */
    @Test
    public void getBillByIdTest()  {
        // uncomment below to test the function
        //Long id = null;
        //BillDto response = api.getBillById(id).block();

        // TODO: test validations
    }
    
    /**
     * Adds a bill
     *
     * Adds a bill to the list of bills in the data source
     */
    @Test
    public void saveBillTest()  {
        // uncomment below to test the function
        //BillDto billDto = null;
        //BillDto response = api.saveBill(billDto).block();

        // TODO: test validations
    }
    
    /**
     * Update a bill
     *
     * Update a bill by a specific id from the list of bills in the data source
     */
    @Test
    public void updateBillTest()  {
        // uncomment below to test the function
        //BillDto billDto = null;
        //BillDto response = api.updateBill(billDto).block();

        // TODO: test validations
    }
    
}
