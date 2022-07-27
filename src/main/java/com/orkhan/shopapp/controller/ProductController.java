package com.orkhan.shopapp.controller;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.entity.Product;
import com.orkhan.shopapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductListDTO getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Object getProduct(@PathVariable Long productId){
        return productService.getById(productId);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Object addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Object updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
