package com.project.resturant.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.resturant.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long id;

    private String name;

    private String LogoPath;

    private String description;

    private Float price;
@JsonIgnore
    private Category category;
}
