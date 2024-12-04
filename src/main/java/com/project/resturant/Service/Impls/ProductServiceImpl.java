package com.project.resturant.Service.Impls;

import com.project.resturant.Dao.ProductDao;
import com.project.resturant.Dtos.ProductDto;
import com.project.resturant.Mappers.ProductMapper;
import com.project.resturant.Service.ProductService;
import com.project.resturant.model.Category;
import com.project.resturant.model.Product;
import jakarta.transaction.SystemException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private    ProductDao productDao;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addProduct(ProductDto productDto) {
      Product product= ProductMapper.productmapper.toEntity(productDto);
      productDao.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
List<Product> products=productDao.findAll();
        return toDtoList(products);
    }

    @Override
    public List<ProductDto> getAllProductsByCategoryId(Long id) {
        List<Product> products=productDao.findByCategory_Id(id);
        return toDtoList(products);
    }

    @Override
    public List<ProductDto> searchBynameOrDesc(String search) throws SystemException {
        List<Product> products=productDao.findAllByDescriptionContainingOrNameContaining(search,search);
        if (products.size()==0){
            throw new SystemException("error.no_results");
        }
        return toDtoList(products);
    }


    public List<ProductDto> toDtoList(List<Product> x){

        List<ProductDto> y=new ArrayList<>();
        Category category=new Category();
        for (int i=0;i<x.size();i++){
            Product e=x.get(i);
            ProductDto productdto = new ProductDto();
            productdto.setId(e.getId());
            productdto.setName(e.getName());
            productdto.setLogoPath(e.getLogoPath());
            productdto.setDescription(e.getDescription());
            productdto.setPrice(e.getPrice());
            category=e.getCategory();
            category.setProduct(null);
            productdto.setCategory(category);
            y.add(productdto);

        }
        return y;
    }




}
