package com.project.resturant.Mappers;

import com.project.resturant.Dtos.ChefsDto;
import com.project.resturant.model.Chefs;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ChefsMapper {
    ChefsMapper chefsmapper= Mappers.getMapper(ChefsMapper.class);
    Chefs toEntity(ChefsDto chefsDto);
    ChefsDto toDto (Chefs chefs);
    List<ChefsDto> toListDto(List<Chefs> chefs);

}
