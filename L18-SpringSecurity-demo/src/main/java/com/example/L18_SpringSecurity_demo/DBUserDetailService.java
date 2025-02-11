package com.example.L18_SpringSecurity_demo;

import com.example.L18_SpringSecurity_demo.entity.AppUser;
import com.example.L18_SpringSecurity_demo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DBUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User does not exist");
        }
        return appUser;
    }
}
