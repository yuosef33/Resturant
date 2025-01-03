package com.project.resturant.Dao;

import com.project.resturant.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {

 Category findByName(String name);
 List<Category> findAllByOrderByName();
}
