package com.project.resturant.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.resturant.model.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfoDto {

    private String name;
    @Email(message = "invalid email")
    private String email;
    private String subject;
    @Column(length = 1000)
    private String message; // make this 1000 as size

}
