package com.project.resturant.Controllers;

import com.project.resturant.Dtos.ProductDto;
import com.project.resturant.Service.ProductService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductCon {
@Autowired
ProductService productService;

    @PostMapping("/add_Product")
    ResponseEntity<Void> add_Product(@Validated @RequestBody ProductDto productDto){
productService.addProduct(productDto);
        return ResponseEntity.created(URI.create("/add_Product")).build();
    }

    @GetMapping("/GetAllProduct")
    ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


@GetMapping("/GetAllproductsById")
    ResponseEntity <List<ProductDto>> getAllProductsById(@RequestParam Long id){
        return ResponseEntity.ok(productService.getAllProductsByCategoryId(id));
}


    @GetMapping("/searchBynameOrDesc")
    ResponseEntity <List<ProductDto>> searchBynameOrDesc(@RequestParam String search) throws SystemException {
        return ResponseEntity.ok(productService.searchBynameOrDesc(search));
    }

}
