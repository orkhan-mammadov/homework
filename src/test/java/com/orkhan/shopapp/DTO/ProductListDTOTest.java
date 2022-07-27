package com.orkhan.shopapp.DTO;

import com.orkhan.shopapp.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductListDTOTest {

    @Test
    void getProducts() {
        List<Product> list = new ArrayList<>();
        Product p = new Product();
        list.add(p);
        ProductListDTO dto = new ProductListDTO(list);
        assertEquals(dto.getProducts().size(),1);
    }

    @Test
    void setProducts() {
        List<Product> list = new ArrayList<>();
        Product p = new Product();
        list.add(p);
        ProductListDTO dto = new ProductListDTO(list);
        dto.setProducts(null);
        assertNull(dto.getProducts());
    }
}