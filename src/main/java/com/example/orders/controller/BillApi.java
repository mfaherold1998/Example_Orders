package com.example.orders.controller;

import com.example.orders.dto.BillDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Bill", description = "the Bill Api")

public interface BillApi {

    @Operation(
            summary = "Fetch all bills",
            description = "Fetches all bills entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<BillDto>> getAllBills();

    @Operation(
            summary = "Fetch a bill by Id",
            description = "Fetches a bill entity and their data from data source by an specific Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<BillDto> getBillById(@PathVariable Long id);

    @Operation(
            summary = "Adds a bill",
            description = "Adds a bill to the list of bills in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added a bill"),
            @ApiResponse(responseCode = "500", description = "invalid bill cannot be added")
    })
    ResponseEntity<BillDto> saveBill (@RequestBody @Valid BillDto billDto);

    @Operation(
            summary = "Delete a bill",
            description = "Delete a bill by a specific id from the list of bills in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "successfully deleted a bill"),
            @ApiResponse(responseCode = "404", description = "there is not bill with the given id")
    })
    ResponseEntity<Void> deleteBill(@PathVariable Long id);

    @Operation(
            summary = "Update a bill",
            description = "Update a bill by a specific id from the list of bills in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully updated a bill"),
            @ApiResponse(responseCode = "404", description = "there is not bill with the given id")
    })
    ResponseEntity<BillDto> updateBill (@RequestBody @Valid BillDto billDto);

}
