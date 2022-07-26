package com.orkhan.shopapp.service;

import com.orkhan.shopapp.DTO.ProductListDTO;
import com.orkhan.shopapp.dao.ProductRepo;
import com.orkhan.shopapp.entity.Product;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    public Object getById(Long productId) {
        return productRepo.findById(productId);
    }

    @Override
    public void createSample() {
        Product sample = new Product();
        sample.setCost(2.5);
        sample.setProductName("first");
        sample.setImg(null);
        sample.setDetails("Details of product");
        productRepo.save(sample);
    }

    @Override
    public void addProduct(Product product) {
//        String fileName = StringUtils.cleanPath(System.currentTimeMillis()+"pp.png");
//        try {
//            Path fileStorage = Paths.get(fileUrl, fileName).toAbsolutePath().normalize();
//            Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//

        productRepo.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId){
        productRepo.deleteById(productId);
    }
}
