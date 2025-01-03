package com.project.resturant.Service;

import com.project.resturant.Dtos.RequestOrderDto;
import com.project.resturant.model.RequestOrder;

import java.util.Map;

public interface RequestOrderService {
   Map<String,String> saveOrder(RequestOrderDto order);
}
