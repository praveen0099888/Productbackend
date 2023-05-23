package com.praveen.ProductManagement.ServiceImpl;

import com.praveen.ProductManagement.Dao.ProductDao;
import com.praveen.ProductManagement.Pojo.Product;
import com.praveen.ProductManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {



    @Autowired
    ProductDao productDao;
    @Override
    public ResponseEntity<List<Product>> getallproduct() {
        try {

                return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
            }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }



    @Override
    public ResponseEntity<String> addProduct(Product p) {
        try {
               Optional<Product> p1 = productDao.findByName(p.getName());
                  if(p1.isEmpty()){
                   productDao.save(p);
                    return new ResponseEntity<String>("{\"message\":\""+ "product added succesfully"+"\"}", HttpStatus.CREATED);}
                  else {
                      return new ResponseEntity<String>("{\"message\":\""+ "same product already present"+"\"}", HttpStatus.BAD_REQUEST);}

        }

        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong ", HttpStatus.BAD_REQUEST);

        }


    @Override
    public ResponseEntity<String> deleteProduct(Integer id) {
        try {
            Optional<Product> p1 = productDao.findById(id);
            if(p1.isPresent()){
                productDao.deleteById(id);
                return new ResponseEntity<String>("{\"message\":\""+ "product deleted succesfully"+"\"}", HttpStatus.CREATED);}
            else {
                return new ResponseEntity<String>("{\"message\":\""+ "No product found with this id "+"\"}", HttpStatus.BAD_REQUEST);}

        }

        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong ", HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<List<Product>> getallexpired() {
        try {

            return new ResponseEntity<>(productDao.findoutofWarranty(), HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
}
