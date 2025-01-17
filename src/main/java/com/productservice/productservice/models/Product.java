package com.productservice.productservice.models;

import com.productservice.productservice.dtos.GenericProductDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;

    //Category isn't a primitive attribute, it's a relation.
    //category_id in the product table.
    @ManyToOne(optional = false)
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Price price;
    private int inventoryCount;

    public GenericProductDto from(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        //genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImage(product.getImage());
        //genericProductDto.setId(product.getId());
        genericProductDto.setInventoryCount(product.getInventoryCount());
        return genericProductDto;
    }
}

/*
    1          1
 Product --- Category
     M         1
 */
