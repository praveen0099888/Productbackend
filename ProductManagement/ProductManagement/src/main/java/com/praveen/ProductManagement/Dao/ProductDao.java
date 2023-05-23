package com.praveen.ProductManagement.Dao;

import com.praveen.ProductManagement.Pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    Optional<Product> findByName(String name);
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:text% OR LOWER(p.type) LIKE %:text% OR LOWER(p.place) LIKE %:text%")
    List<Product> searchByText(String text);
    @Query("SELECT p FROM Product p WHERE p.warranty<YEAR(CURRENT_DATE)")
    List<Product> findoutofWarranty();
    List<Product> findByPlaceContainingIgnoreCase(String place);

}
