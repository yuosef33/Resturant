package com.project.resturant.Service.Impls;

import com.project.resturant.Dao.ChefsDao;
import com.project.resturant.Dtos.ChefsDto;
import com.project.resturant.Mappers.ChefsMapper;
import com.project.resturant.Service.ChefsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefsServiceImpl implements ChefsService {
@Autowired
    ChefsDao chefsDao;
@Autowired
ModelMapper modelMapper;
    @Override
    public List<ChefsDto> getAllChefs() {
return ChefsMapper.chefsmapper.toListDto(chefsDao.findAll());
    }
}
