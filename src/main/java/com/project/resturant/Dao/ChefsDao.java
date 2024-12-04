package com.project.resturant.Dao;

import com.project.resturant.model.Chefs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefsDao extends JpaRepository<Chefs,Long> {
}
