package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseClass {


private String Flag;

@JsonManagedReference
@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
private List<Product> product;
}
