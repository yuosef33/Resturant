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

    @GetMapping("/GetAllProduct/pageNumber/{pageNumber}/pageSize/{pageSize}")
    ResponseEntity<List<ProductDto>> getAllProducts(@PathVariable("pageNumber") int pageNumber,@PathVariable("pageSize")int pageSize){
        return ResponseEntity.ok(productService.getAllProducts(pageNumber,pageSize));
    }


@GetMapping("/GetAllproductsByCategoryId/{id}/pageNumber/{pageNumber}/pageSize/{pageSize}")
    ResponseEntity <List<ProductDto>> getAllProductsById(@PathVariable("id") Long id,@PathVariable("pageNumber") int pageNumber,@PathVariable("pageSize")int pageSize){
        return ResponseEntity.ok(productService.getAllProductsByCategoryId(id,pageNumber,pageSize));
}


    @GetMapping("/searchBynameOrDesc/{search}/pageNumber/{pageNumber}/pageSize/{pageSize}")
    ResponseEntity <List<ProductDto>> searchBynameOrDesc(@PathVariable("search") String search,@PathVariable("pageNumber") int pageNumber,@PathVariable("pageSize")int pageSize) throws SystemException {
        return ResponseEntity.ok(productService.searchBynameOrDesc(search,pageNumber,pageSize));
    }

    @GetMapping("/FindProductSize")
    ResponseEntity <Integer> findProductSize()  {
        return ResponseEntity.ok(productService.findAllProductSize());
    }
    @GetMapping("/FindProductSizeByCategoryId/{id}")
    ResponseEntity <Integer> findProductSize(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(productService.findAllProductSizeByCategoryId(id));
    }

    @GetMapping("/FindProductSizeByKey/{key}")
    ResponseEntity <Integer> findProductSize(@PathVariable("key") String key)  {
        return ResponseEntity.ok(productService.findAllProductSizeByKey(key));
    }
}

