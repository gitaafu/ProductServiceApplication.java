package com.example.Product_Service.DAO;


import com.example.Product_Service.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDAO extends CrudRepository<Product,Long> {

    List<Product> findByCategoryAndSubcategory1AndSubcategory2(String category, String subcategory1, String subcategory2);
}
