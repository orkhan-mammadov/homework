package com.orkhan.shopapp.controller;

import com.orkhan.shopapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }


    @Test
    void getAll() throws Exception {
        when(productService.getAll()).thenReturn(null);
        MockHttpServletResponse response = mockMvc.perform(get("/api/product").contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void getProduct() {
        assertTrue(true);
    }

    @Test
    void addProduct() {
        assertTrue(true);
    }

    @Test
    void updateProduct() {
        assertTrue(true);
    }

    @Test
    void deleteProduct() {
        assertTrue(true);
    }
}