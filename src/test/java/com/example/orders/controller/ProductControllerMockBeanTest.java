package com.example.orders.controller;

import com.example.orders.dto.OrdineDto;
import com.example.orders.dto.ProductDto;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.repository.ProductRepository;
import com.example.orders.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Disabled
@WebMvcTest(ProductController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not product with id "+id);
    }

    @Test
    void getAllProducts_withValidProducts_returnOk() throws Exception {

        ProductDto product1 = ProductDto.builder().name("shampoo").price(10.0).build();
        ProductDto product2 = ProductDto.builder().name("conditioner").price(10.0).build();

        List<ProductDto> products = new ArrayList<ProductDto>();
        products.add(product1);
        products.add(product2);

        Mockito.when(productService.getAllProducts()).thenReturn(products);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    void getAllProducts_withNone_returnEmptyList() throws Exception {

        List<ProductDto> products = new ArrayList<ProductDto>();

        Mockito.when(productService.getAllProducts()).thenReturn(products);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    void getProductById_whitValidProductDto_returnOk() throws Exception{
        Long id = 1L;
        ProductDto response = ProductDto.builder().id(id).name("shampoo").price(10.0).build();

        Mockito.when(productService.getProductById(id)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void getProductById_whitInvalidProductDto_throwException() throws Exception{

        Long id = 1L;

        Mockito.when(productService.getProductById(id)).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void saveProduct_withValidProductDto_returnOk() throws Exception{

        Long id = 1L;
        ProductDto response = ProductDto.builder().id(id).name("shampoo").price(10.0).ords(new ArrayList<OrdineDto>()).build();

        Mockito.when(productService.saveProduct(ArgumentMatchers.any(ProductDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    void saveProduct_withInvalidProductDto_returnOk() throws Exception {

        Long id = 1L;
        ProductDto response = ProductDto.builder().id(id).name(null).price(10.0).build();

        Mockito.when(productService.saveProduct(ArgumentMatchers.any(ProductDto.class))).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
                        .content(objectMapper.writeValueAsString(response))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                //.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void deleteProduct_withExistentProductDto_returnAccepted() throws Exception{

        Long id = 1L;

        Mockito.doNothing().when(productService).deleteProduct(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/products/{id}",id))
                //.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }

    @Test
    void deleteProduct_withNotExistentProductDto_throwNotFoundException() throws Exception{

        Long id = 1L;

        Mockito.doThrow(createNotFoundException(id)).when(productService).deleteProduct(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/products/{id}",id))
                //.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void updateProduct_withValidProductDto_returnOk() throws Exception{

        Long id = 1L;
        ProductDto response = ProductDto.builder().id(id).name("shampoo").price(10.0).ords(new ArrayList<OrdineDto>()).build();

        Mockito.when(productService.updateProduct(ArgumentMatchers.any(ProductDto.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/products")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void updateProduct_withInvalidProductDto_throwNotFoundException() throws Exception{

        Long id = 1L;
        ProductDto response = ProductDto.builder().id(id).name("shampoo").price(10.0).ords(new ArrayList<OrdineDto>()).build();

        Mockito.when(productService.updateProduct(ArgumentMatchers.any(ProductDto.class))).thenThrow(createNotFoundException(id));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/products")
                    .content(objectMapper.writeValueAsString(response))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }
}
