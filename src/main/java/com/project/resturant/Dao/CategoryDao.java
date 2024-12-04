package com.project.resturant.Dao;

import com.project.resturant.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {

 Category findByName(String name);
}
