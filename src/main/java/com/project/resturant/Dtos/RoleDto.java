package com.project.resturant.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.resturant.model.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;
    private String code;
    private Client client;


}
