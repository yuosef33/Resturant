package com.project.resturant.Service.Impls;

import com.project.resturant.Config.util.OrderCode;
import com.project.resturant.Dao.ProductDao;
import com.project.resturant.Dao.RequestOrderDao;
import com.project.resturant.Dtos.RequestOrderDto;
import com.project.resturant.Service.RequestOrderService;
import com.project.resturant.model.Client;
import com.project.resturant.model.Product;
import com.project.resturant.model.RequestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RequestOrderServiceImpl implements RequestOrderService {

    @Autowired
    private RequestOrderDao requestOrderDao;

    @Autowired
    private ProductDao productDao;



    @Override
    public Map<String,String> saveOrder(RequestOrderDto order) {
        List<Product> products= productDao.findByIdIn(order.getProducts());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Client client=(Client) authentication.getPrincipal();
        RequestOrder requestOrder= new RequestOrder();
        requestOrder.setOrder_products(products);
        requestOrder.setClient(client);
        requestOrder.setTotalPrice(order.getTotalPrice());
        requestOrder.setTotalQuantity(order.getTotalQuantity());
        requestOrder.setCode(OrderCode.genrateCode());

        requestOrderDao.save(requestOrder);

        Map<String,String> map=new LinkedHashMap();
        map.put("code",requestOrder.getCode());
return map;
    }
}
