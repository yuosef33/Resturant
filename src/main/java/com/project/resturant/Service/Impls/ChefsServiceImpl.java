package com.project.resturant.Service.Impls;

import com.project.resturant.Dao.ChefsDao;
import com.project.resturant.Dtos.ChefsDto;
import com.project.resturant.Mappers.ChefsMapper;
import com.project.resturant.Service.ChefsService;
import com.project.resturant.model.Chefs;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChefsServiceImpl implements ChefsService {
@Autowired
    ChefsDao chefsDao;
@Autowired
ModelMapper modelMapper;
    @Override
    public List<ChefsDto> getAllChefs() {

return toDtoList(chefsDao.findAll());
    }


   List<ChefsDto> toDtoList(List<Chefs> chefs) {
       List<ChefsDto> chefsDtos = new ArrayList<>();
       for (Chefs chef : chefs) {
           ChefsDto x = new ChefsDto();
           x.setId(chef.getId());
           x.setName(chef.getName());
           x.setFaceLink(chef.getFaceLink());
           x.setInstaLink(chef.getInstaLink());
           x.setTweLink(chef.getTweLink());
           x.setSpecialization(chef.getSpecialization());
           x.setLogoPath(chef.getLogoPath());
           chefsDtos.add(x);
       }
       return chefsDtos;
   }





}
