package com.orkhan.shopapp.service;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.dao.ProductRepo;
import com.orkhan.shopapp.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    private List<Product> productList;

    private Product product;

    @BeforeEach
    public void setup(){
        product = new Product(Long.valueOf(55),"55name",5.5,"details");
        productList = new ArrayList<>();
        Product p1 = new Product(Long.valueOf(1),"name1",1.5,"details");
        Product p2 = new Product(Long.valueOf(2),"name2",2.5,"details");
        Product p3 = new Product(Long.valueOf(3),"name3",3.5,"details");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
    }

    @Test
    void getAll() {
        when(productRepo.findAll()).thenReturn(productList);

        ProductListDTO productListDTO = productService.getAll();

        assertEquals(3,productListDTO.getProducts().size());
    }

    @Test
    void getById() {
        when(productRepo.findById(Long.valueOf(55))).thenReturn(Optional.ofNullable(product));
        Optional<Product> product = productService.getById(Long.valueOf(55));
        assertEquals(product.get().getId(),55);
    }

    @Test
    void addProduct() {
        Product producttemp = new Product(Long.valueOf(4),"name4",4.4,"details");
        when(productRepo.save(producttemp)).thenReturn(producttemp);
        assertEquals(productService.addProduct(producttemp),producttemp);
    }

    @Test
    void updateProduct() {
        Product producttemp = new Product(Long.valueOf(4),"name4",4.4,"details");
        productList.add(producttemp);
        Product product1 = productList.get(3);
        product1.setProductName("changedName");
        productList.add(3,product1);
        when(productService.updateProduct(product1)).thenReturn(productList.get(3));

        assertEquals(productService.updateProduct(product1).getProductName(),"changedName");
    }

    @Test
    void deleteProduct() {
        assertTrue(productService.deleteProduct(2L));
    }
}