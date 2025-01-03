package com.project.resturant.Service.Impls;

import com.project.resturant.Dao.CategoryDao;
import com.project.resturant.Dtos.CategoryDto;
import com.project.resturant.Mappers.CategoryMapper;
import com.project.resturant.Service.CategoryService;
import com.project.resturant.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
       List<Category> categorys= categoryDao.findAllByOrderByName();
     return toListDto(categorys);
//return CategoryMapper.categorymapper.toListDto(categoryDao.findAllByOrderByName());
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return CategoryMapper.categorymapper.toDto(categoryDao.findByName(name));
    }


    List<CategoryDto> toListDto(List<Category>categories){
        List<CategoryDto> categoriesDto=new ArrayList<>();
        for(Category category:categories){
          CategoryDto categoryDto=new CategoryDto();
          categoryDto.setId(category.getId());
          categoryDto.setFlag(category.getFlag());
          categoryDto.setName(category.getName());
          categoryDto.setLogoPath(category.getLogoPath());
          categoryDto.setProduct(null);
            categoriesDto.add(categoryDto);
        }
        return categoriesDto;
    }


}
