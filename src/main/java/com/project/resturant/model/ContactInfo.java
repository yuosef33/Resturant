package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Email(message = "invalid email")
    private String email;
    private String subject;
    @Column(length = 1000)
    private String message; // make this 1000 as size

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;


}
