package com.orkhan.shopapp.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");
        assertEquals(p.getId(),Long.valueOf(5));
    }

    @Test
    void getProductName() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");

        assertEquals(p.getProductName(),"name");
    }

    @Test
    void getCost() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");

        assertEquals(p.getCost(),2.5);
    }

    @Test
    void getDetails() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");

        assertEquals(p.getDetails(),"details");
    }

    @Test
    void setId() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");
        p.setId(Long.valueOf(6));
        assertEquals(p.getId(),Long.valueOf(6));
    }

    @Test
    void setProductName() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");
        p.setProductName("secondName");
        assertEquals(p.getProductName(),"secondName");
    }

    @Test
    void setCost() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");
        p.setCost(3.5);
        assertEquals(p.getCost(),3.5);
    }

    @Test
    void setDetails() {
        Product p = new Product(Long.valueOf(5),"name",2.5,"details");
        p.setDetails("additionalDetails");
        assertEquals(p.getDetails(),"additionalDetails");
    }
}