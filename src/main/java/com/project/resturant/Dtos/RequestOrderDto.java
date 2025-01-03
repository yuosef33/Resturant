package com.project.resturant.Dtos;


import com.project.resturant.model.Client;
import com.project.resturant.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestOrderDto {


   // private String code;
    private String totalPrice;
    private String totalQuantity;
    private List<Long> products;


}
