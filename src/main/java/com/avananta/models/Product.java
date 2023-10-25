package com.avananta.models;


import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@SqlResultSetMapping(
        name = "ProductMapping",
        classes = @ConstructorResult(
                targetClass = Product.class,
                columns = {

                        @ColumnResult(name = "title", type = String.class)
//                        @ColumnResult(name = "price", type = Double.class),
//                        @ColumnResult(name = "description", type = String.class),
                }
        )
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel{

    private String title;

    private double price;

    private String description;
}
