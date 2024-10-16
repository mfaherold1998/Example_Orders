package com.example.orders.repository;

import com.example.orders.entity.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductRepositoryTest {

    @Autowired
    public ProductRepository productRepository;

	@Test
	@Transactional
	void saveAndFlush_withValidProduct_returnSavedProduct() {
		//Create
		Product last = productRepository.findFirstByOrderByIdDesc().orElse(Product.builder().id(0L).build());
		Product product = Product.builder().price(10.0).name("shampoo").build();

		// Act
		Product savedProduct = productRepository.saveAndFlush(product);

		// Assert
		assertNotNull(savedProduct);
        assertEquals(last.getId() + 1, (long) savedProduct.getId());
	}

	@Test
	void findAll_withTwoValidProduct_returnListOfProduct() {

		Product product1 = Product.builder().price(10.0).name("shampoo").build();
		Product product2 = Product.builder().price(10.0).name("conditioner").build();

		List<Product> beforeProduct = productRepository.findAll();

		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> products = productRepository.findAll();

		assertEquals(beforeProduct.size()+2 , products.size());
	}

	@Test
	void findAllByPrice_withTwoValidProducts_returnListOfProducts() {

		Product product1 = Product.builder().price(10.0).name("shampoo").build();
		Product product2 = Product.builder().price(10.0).name("conditioner").build();

		List<Product> beforeProduct = productRepository.findAllByPrice(10.0);

		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> products = productRepository.findAllByPrice(10.0);

		assertEquals(beforeProduct.size()+2, products.size());
	}

	@Test
	void findAllByName_withTwoValidProducts_returnListOfProducts() {

		String name = "shampoo";
		Product product1 = Product.builder().price(10.0).name(name).build();
		Product product2 = Product.builder().price(10.0).name(name).build();

		List<Product> beforeProduct = productRepository.findAllByName(name);

		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> products = productRepository.findAllByName(name);

		assertEquals(beforeProduct.size()+2, products.size());
	}

	@Test
	@Transactional
	void save_withInvalidPrice_throwException(){

		Product product1 = Product.builder().price(10.0).name(null).build();

		assertThrows(DataIntegrityViolationException.class, () -> {
			productRepository.save(product1);
		});
	}

	@Test
	@Transactional
	void deleteById_withValidProduct_returnListOfProducts(){

		Product last = productRepository.findFirstByOrderByIdDesc().orElse(Product.builder().id(0L).build());
		Product product1 = Product.builder().price(10.0).name("shampoo").build();
		Product product2 = Product.builder().price(10.0).name("conditioner").build();

		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> beforeProduct = productRepository.findAll();

		productRepository.deleteById(last.getId()+2);

		List<Product> actualProduct = productRepository.findAll();

		assertEquals(beforeProduct.size()-1, actualProduct.size());

	}

	@Test
	@Transactional
	void deleteById_withNotValidId_returnException(){

		Product last = productRepository.findFirstByOrderByIdDesc().orElse(Product.builder().id(0L).build());

		assertDoesNotThrow(() -> {
			productRepository.deleteById(last.getId() + 1);
		});

	}
}
