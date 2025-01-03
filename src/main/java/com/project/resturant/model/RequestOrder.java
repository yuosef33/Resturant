package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RequestOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String totalPrice;

    private String totalQuantity;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "requestorder_product",
            joinColumns = @JoinColumn(name = "requestorder_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> order_products;    //@many to many

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "client_id",nullable = false)
    private Client client; // many to one

}
