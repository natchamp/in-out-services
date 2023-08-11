package com.inout.in.web;

import com.inout.in.entity.RegistrationInfo;
import com.inout.in.generateddomain.service.dto.RegistrationDetails;
import com.inout.in.service.UserService;
import com.inout.in.service.ValidationService;
import com.inout.in.web.api.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private ValidationService validationService;

    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Override
    public ResponseEntity<Void> postUserRegister(RegistrationDetails registrationDetails) {

        if(!validationService.isEmailAvailable(registrationDetails.getEmail()))
        {
            log.info("Error.....User Already Registered.......");
            return new ResponseEntity("Email Already Exist. Try another one", HttpStatus.OK);
        }
        userService.postUserRegister(registrationDetails);
        log.info("User Registered Successfully");
        return new ResponseEntity("Account Created Successfully...", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Void> getUserLogin(String userName, String password) {

       if(userService.getUserLogin(userName, password)) {
           RegistrationInfo registrationInfo = userService.getUserInfo(userName);
           log.info("Login Successful...  Username - {}", userName);
           String response = "Login Successful...  Username - "+registrationInfo.getFirstName();
           return new ResponseEntity(response, HttpStatus.OK);
       }
        log.info("Error while Log check the credentials");
        return new ResponseEntity("LogIn Failed. Invalid Credentials..", HttpStatus.OK);

    }

}
