package com.project.resturant.Controllers;

import com.project.resturant.Dtos.ProductDto;
import com.project.resturant.Dtos.RequestOrderDto;
import com.project.resturant.Service.RequestOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/requestorder")
public class RequestOrderCon {

    @Autowired
    private RequestOrderService requestOrderService;


    @PostMapping("/saveOrder")
    ResponseEntity<Map<String,String>> saveOrder(@RequestBody RequestOrderDto requestOrderDto){
        return ResponseEntity.created(URI.create("/saveOrder")).body(requestOrderService.saveOrder(requestOrderDto));
    }

}
