package com.avananta.controllers;

import com.avananta.Dtos.ProductDto;
import com.avananta.exceptions.NotFoundException;
import com.avananta.models.Product;
import com.avananta.respositries.ProductRepository;
import com.avananta.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

      private ProductServices productServices;
      private final ProductRepository productRepository;

      @GetMapping("")
      public List<Product> getAllProducts(){
          return productServices.getAllProducts();
      }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException
    {
        //return productService.getSingleProduct(productId);
        //return "Returning single product with id "+productId;

        MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();

        headers.add(
                "auth_token","noaccessfor4youheyhey"
        );
        Optional<Product> productOptional = productServices.getProductById(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("No Product with product id: " + productId);
        }
        ResponseEntity<Product> response=new ResponseEntity(
                productServices.getProductById(productId),
                headers,
                HttpStatus.OK
        );
        // GetSingleProductResponseDto responseDto= new GetSingleProductResponseDto();
        // responseDto.setProduct(productService.getSingleProduct(productId));
        // return responseDto;
        return response;
    }
//      @PostMapping("/get-column-values/{column}")
//      public ResponseEntity<List<String>> getColumnValues(@PathVariable("column") String columnName){
//     //List<String> columnValues = productRepository.findColumnValues(columnName);
//           List<String> columnValues = productServices.getColumnValues(columnName);
//
//            if (!columnValues.isEmpty()) {
//                  return ResponseEntity.ok(columnValues);
//            } else {
//                  return ResponseEntity.notFound().build();
//            }
//      }

      @PostMapping("")
      public ResponseEntity<Product> createProduct(@RequestBody ProductDto productdto){
            Product newProduct = productServices.createProduct(productdto);
            return ResponseEntity.ok(newProduct);
      }

    @PostMapping("/get-column-val/{column}")
      public <T> ResponseEntity<List<T>> QueryGeneric(@PathVariable("column") String statement){
          List<T> columnValues = productServices.executeNativeQueryGeneric(
                  statement,
                  "ProductMapping");

        if (!columnValues.isEmpty()) {
            return ResponseEntity.ok(columnValues);
        } else {
            return ResponseEntity.notFound().build();
        }

      }


    @DeleteMapping("/{productId}")
    public Optional<Product> deleteProduct(@PathVariable("productId") Long productId)throws NotFoundException{

        Optional<Product> productOptional = productServices.deleteProduct(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("No Product with product id: " + productId);
        }
        return productOptional;


    }





}
