package com.project.resturant.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.resturant.model.ContactInfo;
import com.project.resturant.model.RequestOrder;
import com.project.resturant.model.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private  String phoneNumber;

}
