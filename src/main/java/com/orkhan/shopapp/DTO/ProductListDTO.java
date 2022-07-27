package com.orkhan.shopapp.DTO;

import com.orkhan.shopapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductListDTO {
    private List<Product> products;
}
