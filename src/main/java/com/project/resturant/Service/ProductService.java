package com.project.resturant.Service;

import com.project.resturant.Dtos.ProductDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface ProductService {

    public void addProduct(ProductDto productDto);
    public List<ProductDto> getAllProducts();
    public List<ProductDto> getAllProductsByCategoryId(Long id);
    public List<ProductDto> searchBynameOrDesc(String search)throws SystemException;

}
