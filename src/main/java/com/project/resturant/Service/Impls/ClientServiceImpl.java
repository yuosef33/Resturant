package com.project.resturant.Service.Impls;

import com.project.resturant.Config.Jwt.TokenHandler;
import com.project.resturant.Dao.ClientDao;
import com.project.resturant.Service.ClientService;
import com.project.resturant.model.Client;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private TokenHandler tokenHandler;


    @Override
    public Client getClientByEmail(String email) throws SystemException {
        Client client = clientDao.findByEmail(email);

        if (client == null) {
            throw new SystemException("error.user_notFound");
        }

        return client;
    }

    @Override
    public Client checkClientExistByToken(String token) {
        String email = tokenHandler.getSubject(token);

        if(Objects.isNull(email)){
            return null;
        }

        return clientDao.findByEmail(email);
    }
}
