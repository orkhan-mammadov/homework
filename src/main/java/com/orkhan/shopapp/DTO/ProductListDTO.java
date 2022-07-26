package com.orkhan.shopapp.DTO;

import com.orkhan.shopapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductListDTO {
    private List<Product> products;
}
