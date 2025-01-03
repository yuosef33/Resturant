package com.project.resturant.Controllers;

import com.project.resturant.Dao.CategoryDao;
import com.project.resturant.Dtos.CategoryDto;
import com.project.resturant.Dtos.ProductDto;
import com.project.resturant.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Category")
public class CategoryCon {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add_Category")
    ResponseEntity<Void> add_Category(@Validated @RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return ResponseEntity.created(URI.create("/add_Product")).build();
    }

    @GetMapping("/GetAllCategorys")
    ResponseEntity<List<CategoryDto>> get_AllCategorys(){
        return ResponseEntity.ok(categoryService.getAllCategorys());
    }

}
