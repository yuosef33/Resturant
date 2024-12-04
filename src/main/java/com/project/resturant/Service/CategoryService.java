package com.project.resturant.Service;

import com.project.resturant.Dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    public void addCategory(CategoryDto categoryDto);
    public List<CategoryDto> getAllCategorys();
    public CategoryDto getCategoryByName(String name);



}
