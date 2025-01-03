package com.project.resturant.Controllers;

import com.project.resturant.Dtos.CategoryDto;
import com.project.resturant.Dtos.ChefsDto;
import com.project.resturant.Service.ChefsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Chefs")
public class ChefsCon {
    @Autowired
    ChefsService chefsService;


    @GetMapping("/GetAllChefs")
    ResponseEntity<List<ChefsDto>> getAllChefs(){
        return ResponseEntity.ok(chefsService.getAllChefs());
    }

}
