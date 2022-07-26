package com.orkhan.shopapp.service;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ProductListDTO getAll();

    Object getById(Long productId);

    void createSample();

    void addProduct(MultipartFile file, String productName, Double cost);

    void updateProduct(Product product);
}
