package com.bajaj.Dphone.registration.service;
import com.bajaj.Dphone.registration.model.UserDtls;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);

}
