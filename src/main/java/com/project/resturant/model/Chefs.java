package com.project.resturant.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Chefs extends BaseClass{
    private String specialization ;
    private String faceLink;
    private String tweLink;
    private String instaLink;

}
