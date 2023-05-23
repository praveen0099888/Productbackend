package com.praveen.ProductManagement.Service;

import com.praveen.ProductManagement.Pojo.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ResponseEntity<List<Product>> getallproduct();

    ResponseEntity<String> addProduct(Product p);

    ResponseEntity<String> deleteProduct(Integer id);

    ResponseEntity<List<Product>> getallexpired();
}
