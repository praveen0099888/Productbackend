package com.praveen.ProductManagement.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;



@Entity
@DynamicInsert
@DynamicUpdate
@Data
@AllArgsConstructor
@Table(name = "product")
public class Product implements Serializable {

    private static long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type;
    private String place;
    private Integer warranty;

    public Product() {

    }

    public Product(String name, String type, String place, Integer warranty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }
}
