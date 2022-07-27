package com.orkhan.shopapp.service;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.entity.Product;

import java.util.Optional;

public interface ProductService {

    ProductListDTO getAll();

    Optional<Product> getById(Long productId);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Boolean deleteProduct(Long productId);
}
