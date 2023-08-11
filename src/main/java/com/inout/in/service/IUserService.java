package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.RegistrationDetails;

public interface IUserService {

    void postUserRegister(RegistrationDetails registrationDetails);
    boolean getUserLogin(String userName, String password);
}
