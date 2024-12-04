package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.Jar;

@Entity
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseClass {

    private String description;

    private Float price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
