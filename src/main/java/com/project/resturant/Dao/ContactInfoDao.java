package com.project.resturant.Dao;

import com.project.resturant.model.Client;
import com.project.resturant.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoDao extends JpaRepository<ContactInfo,Long> {

}
