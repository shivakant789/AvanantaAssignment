package com.avananta.respositries;

import com.avananta.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    List<Product> findAll();

    Product findProductById(Long id);

    void deleteById(Long id);



//    @Query(value = "SELECT CASE WHEN :columnName = 'title' THEN e.title WHEN :columnName = 'description' THEN e.description ELSE NULL END FROM products e", nativeQuery = true)
//    List<String> findColumnValues(@Param("columnName") String columnName);

//    @Query(value = "SELECT :columnName from products", nativeQuery = true)
//    List<String> findColumnValues(@Param("columnName") String columnName);

}
