package com.example.orders.services;

import com.example.orders.dto.ProductDto;
import com.example.orders.entity.Product;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.ProductMapper;
import com.example.orders.repository.ProductRepository;
import com.example.orders.service.ProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductServiceMockitoTest {

    @Mock
    private ProductRepository productRepository;

    @Spy
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @InjectMocks
    private ProductService productService;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not Bill with id "+id);
    }

    @Test
    void getAllProducts_withValidProductDTO_returnListOProductDto() {

        Product product1 = Product.builder().id(1L).name("shampoo").price(10.0).build();
        Product product2 = Product.builder().id(2L).name("conditioner").price(10.0).build();
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductDto> response = productService.getAllProducts();

        assertEquals(2, response.size());

    }

    @Test
    void getAllProduct_withNone_returnEmptyListOfProductDto() {

        List<Product> products = new ArrayList<>();

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductDto> response = productService.getAllProducts();

        assertEquals(0, response.size());
    }

    @Test
    void saveProduct_withValidProductDTO_returnSavedProductDto() {

        Product product = Product.builder().id(1L).name("shampoo").price(10.0).build();
        ProductDto productDto = ProductDto.builder().id(1L).name("shampoo").price(10.0).build();

        Mockito.when(productRepository.saveAndFlush(ArgumentMatchers.any(Product.class))).thenReturn(product);

        ProductDto savedDto = productService.saveProduct(productDto);

        assertNotNull(savedDto);
    }

    @Test
    void saveProduct_withInvalidProductDTO_throwException() {

        ProductDto productDto = ProductDto.builder().id(1L).name("shampoo").price(10.0).build();


        Mockito.when(productRepository.saveAndFlush(ArgumentMatchers.any(Product.class))).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            productService.saveProduct(productDto);
        });
    }

    @Test
    void saveProduct_withTwoValidDto_returnProductDto() {

        Product product = Product.builder().id(1L).name("shampoo").price(10.0).build();
        ProductDto productDto = ProductDto.builder().id(1L).name("shampoo").price(10.0).build();

        Mockito.when(productRepository.saveAndFlush(ArgumentMatchers.any(Product.class))).thenReturn(product);

        ProductDto savedProduct = productService.saveProduct(productDto);

        assertEquals(1L, savedProduct.getId());
    }

    @Test
    void getProductById_withValidProductDto_returnProductDto(){

        Long id = 1L;
        Product product = Product.builder().id(id).name("shampoo").price(10.0).build();
        Optional<Product> optProduct = Optional.of(product);

        Mockito.when(productRepository.findById(id)).thenReturn(optProduct);

        ProductDto cli = productService.getProductById(id);

        assertNotNull(cli);
        assertEquals(1L, cli.getId());

    }

    @Test
    void getProductById_withInvalidId_throwException(){

        Long id = 1L;

        Mockito.when(productRepository.findById(id)).thenThrow(createNotFoundException(id));

        assertThrows(NotFoundException.class, () -> {
            productService.getProductById(id);
        });
    }

    @Test
    void deleteProduct_withValidProductDto_mockitoVerify(){

        Long id = 1L;

        Mockito.when(productRepository.existsById(id)).thenReturn(true);
        Mockito.doNothing().when(productRepository).deleteById(id);

        productService.deleteProduct(id);

        Mockito.verify(productRepository, Mockito.times(1)).deleteById(id);

    }

    @Test
    void deleteProduct_withInvalidId_throwException(){

        Long id = 1L;

        assertThrows(NotFoundException.class, () -> {
            productService.deleteProduct(id);
        });
    }

    @Test
    void existById_withExistingProductDto_returnTrue(){

        Long id = 1L;

        Mockito.when(productRepository.existsById(id)).thenReturn(true);

        assertTrue(productService.existsById(id));
    }

    @Test
    void updateProduct_withValidProductDto_returnUpdatedProductDto(){

        Long id = 1L;
        Product product = Product.builder().id(id).name("shampoo").price(10.0).build();
        ProductDto productDto = ProductDto.builder().id(id).name("shampoo").price(10.0).build();

        Mockito.when(productRepository.saveAndFlush(ArgumentMatchers.any(Product.class))).thenReturn(product);
        Mockito.when(productRepository.existsById(id)).thenReturn(true);

        ProductDto updatedProduct = productService.updateProduct(productDto);

        assertEquals(id, updatedProduct.getId());
        assertEquals("shampoo", updatedProduct.getName());

    }

    @Test
    void updateProduct_withInvalidProductDto_throwException(){

        Long id = 1L;
        ProductDto productDto = ProductDto.builder().id(id).build();

        Mockito.when(productRepository.existsById(id)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> {
            productService.updateProduct(productDto);
        });
    }

}
