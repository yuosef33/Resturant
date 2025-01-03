package com.project.resturant.Service;

import com.project.resturant.Dtos.ClientDto;
import com.project.resturant.Dtos.TokenDto;
import com.project.resturant.Dtos.UserLoginDto;
import jakarta.transaction.SystemException;

public interface UserAuthService {

    public TokenDto login(UserLoginDto userLoginDto) throws SystemException;
    void CreatUserAccount(ClientDto clientDto) throws SystemException;

}
