package com.orkhan.shopapp.controller;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.entity.Product;
import com.orkhan.shopapp.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ProductListDTO getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Object getProduct(@PathVariable Long productId){
        return productService.getById(productId);
    }

    @PostMapping()
    public Object addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return null;
    }

    @GetMapping("/createSample")
    public Object createSample(){
        productService.createSample();
        return null;
    }

    @PutMapping()
    public Object updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return null;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
