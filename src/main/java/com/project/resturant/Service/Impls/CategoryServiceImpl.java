package com.project.resturant.Service.Impls;

import com.project.resturant.Dao.CategoryDao;
import com.project.resturant.Dtos.CategoryDto;
import com.project.resturant.Mappers.CategoryMapper;
import com.project.resturant.Service.CategoryService;
import com.project.resturant.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addCategory(CategoryDto categoryDto) {
        Category category= CategoryMapper.categorymapper.toEntity(categoryDto);
        categoryDao.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategorys() {
      return CategoryMapper.categorymapper.toListDto(categoryDao.findAll());

    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return CategoryMapper.categorymapper.toDto(categoryDao.findByName(name));
    }

}
