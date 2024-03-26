package com.example.Product_Service.service;

import com.example.Product_Service.DAO.ProductDAO;
import com.example.Product_Service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    @Autowired
    private ProductDAO productDAO;

    public Product addNewProduct(Product product){
        return productDAO.save(product);
    }

    public List<Product> getAllProducts()
    {
        return (List<Product>)productDAO.findAll();
    }

    public void deleteProduct(Long product_id)
    {
        productDAO.deleteById(product_id);
    }

    public List<Product> getProductsByCategoryAndSubcategory1AndSubcategory2(String category, String subcategory1, String subcategory2) {
        return productDAO.findByCategoryAndSubcategory1AndSubcategory2(category, subcategory1, subcategory2);
    }
}