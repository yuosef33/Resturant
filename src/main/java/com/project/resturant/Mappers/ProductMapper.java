package com.project.resturant.Mappers;

import com.project.resturant.Dtos.ProductDto;
import com.project.resturant.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper productmapper= Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDto productDto);

    ProductDto  toDto (Product Product);

    List<ProductDto> toListDto(List<Product> Products);


}
