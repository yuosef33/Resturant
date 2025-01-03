package com.project.resturant.Controllers;


import com.project.resturant.Dtos.ClientDto;
import com.project.resturant.Dtos.TokenDto;
import com.project.resturant.Dtos.UserLoginDto;
import com.project.resturant.Service.UserAuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;



@RestController
@RequestMapping("/User")
public class UserCon {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/Login")
    ResponseEntity<TokenDto> Login(@RequestBody UserLoginDto userLoginDto) throws SystemException {
        return ResponseEntity.ok(userAuthService.login(userLoginDto));
    }
    @PostMapping("/Signup")
    ResponseEntity<Void> signup(@RequestBody ClientDto clientDto) throws SystemException {
        userAuthService.CreatUserAccount(clientDto);
        return ResponseEntity.created(URI.create("/Signup")).build();
    }

}
