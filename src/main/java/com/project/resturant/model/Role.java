package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",nullable = false)
    private Client client; // many to one


}
