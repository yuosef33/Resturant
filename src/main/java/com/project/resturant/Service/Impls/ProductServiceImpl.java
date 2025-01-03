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
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<ProductDto> getAllProducts(int pageNumber,int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Product> productPage = productDao.findAll(pageable);
        List<Product> products=productPage.stream().collect(Collectors.toList());
        return toDtoList(products);
    }

    @Override
    public List<ProductDto> getAllProductsByCategoryId(Long id,int pageNumber,int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Product> products=productDao.findByCategory_Id(id,pageable);
        List<Product> fproducts=products.stream().collect(Collectors.toList());
        return toDtoList(fproducts);
    }

    @Override
    public List<ProductDto> searchBynameOrDesc(String search,int pageNumber,int pageSize) throws SystemException {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Product> products=productDao.findAllByDescriptionContainingIgnoreCaseOrNameContainingIgnoreCase(search,search,pageable);
        List<Product> fproducts=products.stream().collect(Collectors.toList());
        if (fproducts.size()==0){
            throw new SystemException("error.no_results");
        }
        return toDtoList(fproducts);
    }

    @Override
    public int findAllProductSize() {
        return productDao.findProductSize();
    }

    @Override
    public int findAllProductSizeByCategoryId(Long id) {
        return productDao.findProductSizeOfByCategoryId(id);
    }

    @Override
    public int findAllProductSizeByKey(String key) {
        return productDao.findProductSizeByKey(key) ;
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
