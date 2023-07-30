package com.inout.in.web.api;

import com.inout.in.generateddomain.service.dto.RegistrationDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;

public interface UserApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /user/login : Your GET endpoint
     *
     * @param userName  (optional)
     * @param password  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getUserLogin",
            summary = "Your GET endpoint",
            tags = {  },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user/login"
    )
    default ResponseEntity<Void> _getUserLogin(
            @Parameter(name = "userName", description = "") @Valid @RequestParam(value = "userName", required = false) String userName,
            @Parameter(name = "password", description = "") @Valid @RequestParam(value = "password", required = false) String password
    ) {
        return getUserLogin(userName, password);
    }

    // Override this method
    default  ResponseEntity<Void> getUserLogin(String userName, String password) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/register : post-user
     *
     * @param registrationDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "postUserRegister",
            summary = "post-user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/user/register",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> _postUserRegister(
            @Parameter(name = "RegistrationDetails", description = "") @Valid @RequestBody(required = false) RegistrationDetails registrationDetails
    ) {
        return postUserRegister(registrationDetails);
    }

    // Override this method
    default  ResponseEntity<Void> postUserRegister(RegistrationDetails registrationDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
