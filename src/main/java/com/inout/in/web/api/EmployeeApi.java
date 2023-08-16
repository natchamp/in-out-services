package com.inout.in.web.api;

import com.inout.in.generateddomain.ApiUtil;
import com.inout.in.generateddomain.service.dto.EmployeeDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface EmployeeApi {


    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /employee/{id} :
     *
     * @param id  (required)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "deleteEmployeeId",
            summary = "",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/employee/remove"
    )
    default ResponseEntity<Void> _deleteEmployeeId(
            @Parameter(name = "EmployeeDetails", description = "") @Valid @RequestBody(required = false) EmployeeDetails employeeDetails
    ) {
        return deleteEmployeeId(employeeDetails);
    }

    // Override this method
    default  ResponseEntity<Void> deleteEmployeeId(EmployeeDetails employeeDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }





    /**
     * GET /employee/all : Your GET endpoint
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getEmployeeAll",
            summary = "Your GET endpoint",
            tags = {  },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employee/all",
            produces = { "application/json" }
    )
    default ResponseEntity<List<EmployeeDetails>> _getEmployeeAll(

    ) {
        return getEmployeeAll();
    }

    // Override this method
    default  ResponseEntity<List<EmployeeDetails>> getEmployeeAll() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"date\", \"inTime\" : \"inTime\", \"reason\" : \"reason\", \"image\" : \"image\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /employee/{id} : Your GET endpoint
     *
     * @param id  (required)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getEmployeeId",
            summary = "Your GET endpoint",
            tags = {  },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employee/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<EmployeeDetails> _getEmployeeId(
            @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id
    ) {
        return getEmployeeId(id);
    }

    // Override this method
    default  ResponseEntity<EmployeeDetails> getEmployeeId(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"date\", \"inTime\" : \"inTime\", \"reason\" : \"reason\", \"image\" : \"image\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /employee/new : employee-out-of-office
     *
     * @param employeeDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "patchEmployeeNew",
            summary = "employee-out-of-office",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/employee/new",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> _patchEmployeeNew(
            @Parameter(name = "EmployeeDetails", description = "") @Valid @RequestBody(required = false) EmployeeDetails employeeDetails
    ) {
        return patchEmployeeNew(employeeDetails);
    }

    // Override this method
    default  ResponseEntity<Void> patchEmployeeNew(EmployeeDetails employeeDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /employee/new :
     *
     * @param employeeDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "postEmployeeNew",
            summary = "",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/employee/new",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> _postEmployeeNew(
            @Parameter(name = "EmployeeDetails", description = "") @Valid @RequestBody(required = false) EmployeeDetails employeeDetails
    ) {
        return postEmployeeNew(employeeDetails);
    }

    // Override this method
    default  ResponseEntity<Void> postEmployeeNew(EmployeeDetails employeeDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
