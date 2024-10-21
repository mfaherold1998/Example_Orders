package com.example.orders.controller;

import com.example.orders.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Client", description = "the Client Api")

public interface ClientApi {

    @Operation(
            summary = "Fetch all clients",
            description = "Fetches all clients entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<ClientDto>> getAllClients();

    @Operation(
            summary = "Fetch a client by Id",
            description = "Fetches a client entity and their data from data source by an specific Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<ClientDto> getClientById(@PathVariable Long id);

    @Operation(
            summary = "Adds a client",
            description = "Adds a client to the list of clients in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added a client"),
            @ApiResponse(responseCode = "500", description = "invalid client cannot be added")
    })
    ResponseEntity<ClientDto> saveClient (@RequestBody @Valid ClientDto clientDto);

    @Operation(
            summary = "Delete a client",
            description = "Delete a client by a specific id from the list of clients in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "successfully deleted a client"),
            @ApiResponse(responseCode = "404", description = "there is not client with the given id")
    })
    ResponseEntity<Void> deleteClient(@PathVariable Long id);

    @Operation(
            summary = "Update a client",
            description = "Update a client by a specific id from the list of clients in the data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully updated a client"),
            @ApiResponse(responseCode = "404", description = "there is not client with the given id")
    })
    ResponseEntity<ClientDto> updateClient (@RequestBody @Valid ClientDto clientDto);

}
