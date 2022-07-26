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

    @GetMapping("/all")
    public ProductListDTO getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Object getProduct(@PathVariable Long productId){
        return productService.getById(productId);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public Object addProduct(@RequestParam(name = "file", required = false)MultipartFile file,
                             @RequestParam("productName") String productName,
                             @RequestParam("cost") Double cost){
        productService.addProduct(file,productName,cost);
        return null;
    }

    @GetMapping("/createSample")
    public Object createSample(){
        productService.createSample();
        return null;
    }

    @PutMapping("/")
    public Object updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return null;
    }
}
