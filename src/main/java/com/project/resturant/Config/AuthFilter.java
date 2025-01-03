package com.project.resturant.Config;

import com.project.resturant.Config.Jwt.TokenHandler;
import com.project.resturant.Service.ClientService;
import com.project.resturant.Sitting.TokenConfig;
import com.project.resturant.model.Client;
import com.project.resturant.model.Role;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
public class AuthFilter extends OncePerRequestFilter {

@Autowired
    private TokenHandler tokenHandler;
@Autowired
private ClientService clientService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        String path=request.getServletPath();
        if(path.contains("Login")|| path.contains("Signup"))
        return true;

        return false;


    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

if (!token.startsWith("Bearer")){
    response.reset();
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    return;

}
        token=token.substring(7);


            if(!tokenHandler.isValidToken(token)){

                response.reset();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                return;

            }


        Client client= clientService.checkClientExistByToken(token);


        if(Objects.isNull(client)){
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(client,null,extractAuths(client.getRoles()));

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request,response);

    }


    private List<GrantedAuthority> extractAuths(Set<Role> roles) {
        List<GrantedAuthority> roles1 = new ArrayList<>();
        for (Role role : roles) {
            SimpleGrantedAuthority z = new SimpleGrantedAuthority("ROLE_" + role.getCode());
            roles1.add(z);

        }
        return roles1;

    }

}
