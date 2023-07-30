package com.inout.in.service;

import com.inout.in.entity.RegistrationInfo;
import com.inout.in.generateddomain.service.dto.RegistrationDetails;
import com.inout.in.mapper.UserMapper;
import com.inout.in.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    private Logger log = LoggerFactory.getLogger(UserService.class);

    public void postUserRegister(RegistrationDetails registrationDetails){
        repository.save(UserMapper.getRegistrationInfoDTO(registrationDetails));
        log.info("User Register Successfully.....");

    }

    public boolean getUserLogin(String userName, String password){
        long count = repository.countByEmailAndPassword(userName, password);
        log.info("User Authenticated Successfully.....");
        return count==1 ? true : false;
    }

    public RegistrationInfo getUserInfo(String userName){
        RegistrationInfo info = repository.findByEmail(userName);
        return info;
    }
}
