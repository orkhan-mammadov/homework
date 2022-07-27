package com.orkhan.shopapp.service;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.dao.ProductRepo;
import com.orkhan.shopapp.entity.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

//    @Value("${app-resource.fileUrl}")
    private String fileUrl = "C:\\Users\\orkhan.mammadov\\Downloads\\shopapp\\shopapp\\uploads";

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductListDTO getAll(){
        return new ProductListDTO(productRepo.findAll());
    }

    @Override
    public Optional<Product> getById(Long productId) {
        return productRepo.findById(productId);
    }


    @Override
    public Product addProduct(Product product) {
//        String fileName = StringUtils.cleanPath(System.currentTimeMillis()+"pp.png");
//        try {
//            Path fileStorage = Paths.get(fileUrl, fileName).toAbsolutePath().normalize();
//            Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//

        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Boolean deleteProduct(Long productId){
        productRepo.deleteById(productId);
        return true;
    }
}
