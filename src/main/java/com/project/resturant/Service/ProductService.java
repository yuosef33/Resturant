package com.project.resturant.Service;

import com.project.resturant.Dtos.ProductDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface ProductService {

    public void addProduct(ProductDto productDto);
    public List<ProductDto> getAllProducts(int pageNumber,int pageSize);
    public List<ProductDto> getAllProductsByCategoryId(Long id,int pageNumber,int pageSize);
    public List<ProductDto> searchBynameOrDesc(String search,int pageNumber,int pageSize)throws SystemException;
    public int findAllProductSize();
    public int findAllProductSizeByCategoryId(Long id);
    public int findAllProductSizeByKey(String key);
}
