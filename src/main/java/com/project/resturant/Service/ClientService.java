package com.project.resturant.Service;

import com.project.resturant.model.Client;
import jakarta.transaction.SystemException;

public interface ClientService {
    Client getClientByEmail(String email) throws SystemException;


    Client checkClientExistByToken(String token);

}
