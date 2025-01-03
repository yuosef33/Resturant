package com.project.resturant.Mappers;

import com.project.resturant.Dtos.CategoryDto;
import com.project.resturant.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper categorymapper= Mappers.getMapper(CategoryMapper.class);


    Category toEntity(CategoryDto categoryDto);

//@Mapping(target = "product", ignore = true)
    CategoryDto  toDto (Category category);

  //  @Mapping(target = "product", ignore = true)
    List<CategoryDto> toListDto(List<Category> categorys);



}
