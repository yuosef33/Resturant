package com.project.resturant.Dao;

import com.project.resturant.model.Category;
import com.project.resturant.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
Page<Product> findByCategory_Id(Long id, Pageable pageable);
    List<Product> findByIdIn(List<Long> ids);
//List<Product> searchAllByDescriptionOrName (String search,String search2);
    Page<Product> findAllByDescriptionContainingIgnoreCaseOrNameContainingIgnoreCase(String search, String search2, Pageable pageable);

@Query(value = "select count(id) from Product",nativeQuery = true)
    int findProductSize();

    @Query(value = "select count(id) from Product where category.id=?1")
    int findProductSizeOfByCategoryId(Long id);


    @Query(value = "select count(id) from Product where LOWER(name) LIKE  '%' || LOWER(:val) || '%' "+
            "OR LOWER(description) LIKE '%' || LOWER(:val) || '%'",nativeQuery = true)
    int findProductSizeByKey(@Param("val") String key);




}
