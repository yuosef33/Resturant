package com.project.resturant.Controllers;

import com.project.resturant.Dtos.ContactInfoDto;
import com.project.resturant.Dtos.ProductDto;
import com.project.resturant.Service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/contactinfo")
public class ContactInfoCon {
    @Autowired
    private ContactInfoService contactInfoService;


    @PostMapping("/save_message")
    ResponseEntity<Void> Save_message(@RequestBody ContactInfoDto contactInfoDto){
contactInfoService.saveMessage(contactInfoDto);
        return ResponseEntity.created(URI.create("/save_message")).build();
    }


}
