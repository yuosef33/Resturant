package com.project.resturant.Dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.resturant.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    private Long id;

    private String name;

    private String LogoPath;

    private String Flag;

    private List<Product> product;


}
