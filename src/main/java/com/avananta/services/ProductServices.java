package com.avananta.services;

import com.avananta.Dtos.ProductDto;
import com.avananta.exceptions.NotFoundException;
import com.avananta.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public interface ProductServices {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id) throws NotFoundException;

    Product createProduct(ProductDto productdto);

    Optional<Product> deleteProduct(Long id) throws NotFoundException;

    Product updateProduct(Product product, Long id);

//    List<String> getColumnValues(String columnName);

    public  <T> List<T> executeNativeQueryGeneric(String statement, String mapping);
}
