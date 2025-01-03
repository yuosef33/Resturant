package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.Jar;

import java.util.List;

@Entity
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseClass {
@Column(length = 700)
    private String description;

    private Float price;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @JsonBackReference
    @ManyToMany(mappedBy = "order_products",cascade = CascadeType.REMOVE)
    private List<RequestOrder> requestOrderList;

}
