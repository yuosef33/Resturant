package com.project.resturant.Service.Impls;

import com.project.resturant.Config.Jwt.TokenHandler;
import com.project.resturant.Dao.ClientDao;
import com.project.resturant.Dao.RoleDao;
import com.project.resturant.Dtos.ClientDto;
import com.project.resturant.Dtos.TokenDto;
import com.project.resturant.Dtos.UserLoginDto;
import com.project.resturant.Service.ClientService;
import com.project.resturant.Service.UserAuthService;
import com.project.resturant.model.Client;
import com.project.resturant.model.Role;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder ;



    public TokenDto login(UserLoginDto userLoginDto) throws SystemException {
        Client client = clientService.getClientByEmail(userLoginDto.getEmail());

if(client==null){
    throw  new SystemException("user not found ");
}

        if (!passwordEncoder.matches(userLoginDto.getPassword(),client.getPassword())) {
            throw new SystemException("error.user_not_found");
        }

        return new TokenDto(tokenHandler.createToken(client));
    }


    @Override
    public void CreatUserAccount(ClientDto clientDto) throws SystemException {
        Client clientExist=clientDao.findByEmail(clientDto.getEmail());
        if(clientExist!=null){
            throw new SystemException("error.email_exist");
        }
        Client client= toEntity(clientDto);
        clientDao.save(client);
        Role role=new Role();
        role.setCode("USER");
        role.setClient(client);
        roleDao.save(role);
    }



   private Client toEntity(ClientDto clientDto){
       Client client=new Client();
       client.setId(clientDto.getId());
       client.setEmail(clientDto.getEmail());
     //  client.setContactInfo(clientDto.getContactInfo());
       client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
       client.setName(clientDto.getName());
      // client.setRoles(clientDto.getRoles());
       client.setPhoneNumber(clientDto.getPhoneNumber());
     //  client.setRequestOrders(clientDto.getRequestOrders());
        return client;
   }

}
