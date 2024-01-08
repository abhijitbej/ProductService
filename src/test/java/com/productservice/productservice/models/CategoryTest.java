package com.productservice.productservice.models;

import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;

    UUID categoryId;
    UUID productId;
    UUID priceId;

    @BeforeEach
    //@Commit
    void init() {
        Category category = categoryRepository.getCategoryByName("Electronics");
        if (category == null) {
            categoryId = UUID.randomUUID();
            category = new Category();
            category.setId(categoryId);
            category.setName("Electronics");
            categoryRepository.save(category);
        } else {
            categoryId = category.getId();
        }


        priceId = UUID.randomUUID();
        Price price = new Price();
        price.setId(priceId);
        price.setCurrency("INR");
        price.setValue(70000.0);
        priceRepository.save(price);

        productId = UUID.randomUUID();
        Product product = new Product();
        product.setCategory(category);
        product.setImage("url.com/iphone15.jpg");
        product.setPrice(price);
        product.setTitle("Iphone 15");
        product.setDescription("Good phone");
        product.setInventoryCount(50);
        productRepository.save(product);
    }

    //@AfterEach
    void cleanUp() {
        productRepository.deleteById(productId);
        priceRepository.deleteById(priceId);
        categoryRepository.deleteById(categoryId);
    }

    @Test
    void testGeneral() {
        Category category = categoryRepository.getCategoryByName("Electronics");
        assertEquals("Electronics", category.getName());
    }

    @Test
    void testLazy() {
        Category category = categoryRepository.getCategoryByName("Electronics");
        assertThrows(LazyInitializationException.class, () -> category.getProducts().size());
    }

    @Test
    @Transactional
    void testLazy2() {
        Category category = categoryRepository.getCategoryByName("Electronics");
        assertEquals("Electronics", category.getProducts().get(0).getCategory().getName());
    }
}