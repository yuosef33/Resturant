package com.project.resturant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Client {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private  String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
   private Set<RequestOrder> requestOrders = new HashSet<>(); //  @OneToMany

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role> roles; //   @OneToMany

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ContactInfo> contactInfo;






}
