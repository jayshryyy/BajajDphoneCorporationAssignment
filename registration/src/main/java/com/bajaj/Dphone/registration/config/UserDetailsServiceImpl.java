package com.bajaj.Dphone.registration.config;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//checking email is correct or not
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.bajaj.Dphone.registration.model.UserDtls;
import com.bajaj.Dphone.registration.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDtls user = userRepo.findByEmail(email);

        if (user != null) {
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("user not available");
    }
}
