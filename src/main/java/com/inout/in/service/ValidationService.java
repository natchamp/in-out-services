package com.inout.in.service;

import com.inout.in.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    private UserRepository repository;

    private Logger log = LoggerFactory.getLogger(ValidationService.class);

    public boolean isEmailAvailable(String email){

        long count = repository.countByEmail(email);

        if(count>0)
        {
            log.info("Email already present....Try with new One");
            return false;
        }
        return true;
    }
}
