package com.avananta.services;

import com.avananta.Dtos.ProductDto;
import com.avananta.exceptions.NotFoundException;
import com.avananta.models.Product;
import com.avananta.respositries.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServices{

    private EntityManager entityManager;

    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) throws NotFoundException{
        Product product= productRepository.findProductById(id);

        if(product==null){
            return  Optional.empty();
        }
        return Optional.of(product);
    }

    @Override
    public Product createProduct(ProductDto productdto) {
        Product newproduct= new Product();
        newproduct.setDescription(productdto.getDescription());
        newproduct.setTitle(productdto.getTitle());
        newproduct.setPrice(productdto.getPrice());
        newproduct=productRepository.save(newproduct);
        return newproduct;
    }

    @Override
    @Transactional
    public Optional<Product> deleteProduct(Long id) throws NotFoundException {
        Product product=productRepository.findProductById((long)id);

        if(product==null){
            return Optional.empty();
        }

        productRepository.deleteById(id);




        return  Optional.of(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return null;
    }
//    @Override
//    public List<String> getColumnValues(String columnName) {
//        String sql = "SELECT " + columnName + " FROM product";
//        Query query = entityManager.createNativeQuery(sql);
//        List<String> ans= new ArrayList<>();
//
//        for(Object o : query.getResultList()){
//            ans.add(o.toString());
//        }
//        return ans;
//    }

    @Override

    public <T> List<T> executeNativeQueryGeneric(String columnName, String mapping) {
        String sql = "SELECT " + columnName + " FROM product";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}
