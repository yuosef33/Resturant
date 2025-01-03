package com.project.resturant.Dao;

import com.project.resturant.model.RequestOrder;
import com.project.resturant.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {

}
