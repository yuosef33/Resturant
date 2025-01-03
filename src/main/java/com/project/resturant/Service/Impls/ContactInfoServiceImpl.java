package com.project.resturant.Service.Impls;

import com.project.resturant.Dao.ContactInfoDao;
import com.project.resturant.Dtos.ContactInfoDto;
import com.project.resturant.Service.ContactInfoService;
import com.project.resturant.model.Client;
import com.project.resturant.model.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    @Autowired
    private ContactInfoDao contactInfoDao;

    @Override
    public void saveMessage(ContactInfoDto contactInfoDto) {
        try {
        ContactInfo contactInfo=new ContactInfo();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client=(Client) authentication.getPrincipal();
        contactInfo.setClient(client);
        contactInfo.setName(contactInfoDto.getName());
        contactInfo.setMessage(contactInfoDto.getMessage());
        contactInfo.setSubject(contactInfoDto.getSubject());
            contactInfo.setEmail(contactInfoDto.getEmail());
            contactInfoDao.save(contactInfo);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

}
