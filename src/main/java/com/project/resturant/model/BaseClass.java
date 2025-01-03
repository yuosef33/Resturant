package com.project.resturant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseClass {
 @Id
 @GeneratedValue(strategy =  GenerationType.IDENTITY)
 private Long id;
@Column(unique = true)
 private String name;

 private String LogoPath;


}
