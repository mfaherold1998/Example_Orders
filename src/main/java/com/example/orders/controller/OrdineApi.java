package com.example.orders.controller;

import com.example.orders.dto.OrdineDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Ordine", description = "the Ordine Api")

public interface OrdineApi {

    @Operation(
            summary = "Fetch all ordini",
            description = "Fetches all ordini entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<OrdineDto>> getAllOrdini();

    @Operation(
            summary = "Fetch a ordine by Id",
            description = "Fetches a ordine entity and their data from data source by an specific Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<OrdineDto> getOrdineById(@PathVariable Long id);

    @Operation(
            summary = "Adds a ordine",
            description = "Adds a ordine to the list of ordini in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added a ordine"),
            @ApiResponse(responseCode = "500", description = "invalid ordine cannot be added")
    })
    ResponseEntity<OrdineDto> saveOrdine (@RequestBody @Valid OrdineDto ordineDto);

    @Operation(
            summary = "Delete a ordine",
            description = "Delete a ordine by a specific id from the list of ordini in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "successfully deleted a ordine"),
            @ApiResponse(responseCode = "404", description = "there is not ordine with the given id")
    })
    ResponseEntity<Void> deleteOrdine(@PathVariable Long id);

    @Operation(
            summary = "Update a ordine",
            description = "Update a ordine by a specific id from the list of ordini in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully updated a ordine"),
            @ApiResponse(responseCode = "404", description = "there is not ordine with the given id")
    })
    ResponseEntity<OrdineDto> updateOrdine (@RequestBody @Valid OrdineDto ordineDto);

}
