package com.praveen.ProductManagement.Rest;


import com.praveen.ProductManagement.Pojo.Product;
import com.praveen.ProductManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductRest {


    @Autowired
    ProductService productService;


    @GetMapping(path = "/getall")
    public ResponseEntity<List<Product>> getAllproducts() {
        try{
            return productService.getallproduct();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

   @PostMapping(path = "/add")
    public ResponseEntity<String> product(@RequestBody(required = true) Product p) {
        try{
            return productService.addProduct(p);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedriver(@PathVariable Integer id){
        try{
            return  productService.deleteProduct(id);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/getallexpired")
    public ResponseEntity<List<Product>> getAllexpiredproducts() {
        try{
            return productService.getallexpired();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
