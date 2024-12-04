package com.project.resturant.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChefsDto {



    private Long id;

    private String name;

    private String LogoPath;

    private String specialization ;
    private String faceLink;
    private String tweLink;
    private String instaLink;

}
