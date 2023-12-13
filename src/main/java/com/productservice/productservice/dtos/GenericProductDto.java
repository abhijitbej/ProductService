package com.productservice.productservice.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class GenericProductDto {
    private Long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
