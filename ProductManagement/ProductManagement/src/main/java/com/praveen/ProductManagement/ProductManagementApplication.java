package com.praveen.ProductManagement;

import com.praveen.ProductManagement.Dao.ProductDao;
import com.praveen.ProductManagement.Pojo.Product;
import com.praveen.ProductManagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagementApplication implements CommandLineRunner {
  @Autowired
	ProductService productService;


	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productService.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
		productService.addProduct(new Product("MacStudio", "Computer", "White Table", 2025));
		productService.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
		productService.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
		productService.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
		productService.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
		productService.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
		productService.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
		productService.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
		productService.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
		productService.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
		productService.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
		productService.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
		productService.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
		productService.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));
	}


}
