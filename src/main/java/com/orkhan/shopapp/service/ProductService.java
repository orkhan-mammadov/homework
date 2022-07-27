package com.orkhan.shopapp.service;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ProductListDTO getAll();

    Object getById(Long productId);

    Product createSample();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long productId);
}
