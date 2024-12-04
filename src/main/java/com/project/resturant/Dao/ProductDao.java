package com.project.resturant.Dao;

import com.project.resturant.model.Category;
import com.project.resturant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
List<Product> findByCategory_Id(Long id);

List<Product> searchAllByDescriptionOrName (String search,String search2);
    List<Product> findAllByDescriptionContainingOrNameContaining(String search,String search2);

}
