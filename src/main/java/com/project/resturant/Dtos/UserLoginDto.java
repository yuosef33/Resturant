package com.project.resturant.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class UserLoginDto {

    private String email;
    private String password;


}
