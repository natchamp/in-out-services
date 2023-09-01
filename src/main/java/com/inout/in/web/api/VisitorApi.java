package com.inout.in.web.api;

import com.inout.in.entity.VisitorInfo;
import com.inout.in.generateddomain.ApiUtil;
import com.inout.in.generateddomain.service.dto.PersonDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface VisitorApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /visitor/{id} :
     *
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "deleteVisitorId",
            summary = "",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/visitor/remove"
    )
    default ResponseEntity<Void> _deleteVisitor(
            @Parameter(name = "PersonDetails", description = "") @Valid @RequestBody(required = false) PersonDetails personDetails
    ) {
        return deleteVisitor(personDetails);
    }

    // Override this method
    default  ResponseEntity<Void> deleteVisitor(PersonDetails personDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /visitor/all : get-visitors-list
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getVisitorAll",
            summary = "get-visitors-list",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/visitor/all",
            produces = { "application/json" }
    )
    default ResponseEntity<List<PersonDetails>> _getVisitorAll(

    ) {
        return getVisitorAll();
    }

    // Override this method
    default  ResponseEntity<List<PersonDetails>> getVisitorAll() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"inTime\" : \"inTime\", \"date\" : \"date\", \"reason\" : \"reason\", \"whomToMeet\" : \"whomToMeet\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /visitor/latest : get-visitors-list
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getVisitorLatest",
            summary = "get-visitors-list",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/visitor/latest",
            produces = { "application/json" }
    )
    default ResponseEntity<List<PersonDetails>> _getVisitorLatest(

    ) {
        return getVisitorLatest();
    }

    // Override this method
    default  ResponseEntity<List<PersonDetails>> getVisitorLatest() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"inTime\" : \"inTime\", \"date\" : \"date\", \"reason\" : \"reason\", \"whomToMeet\" : \"whomToMeet\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /visitor/latestid : get-visitors-list
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getVisitorLatestId",
            summary = "get-visitors-list",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/visitor/latestid",
            produces = { "application/json" }
    )
    default ResponseEntity<String> _getVisitorLatestId(

    ) {
        return getVisitorLatestId();
    }

    // Override this method
    default  ResponseEntity<String> getVisitorLatestId() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"inTime\" : \"inTime\", \"date\" : \"date\", \"reason\" : \"reason\", \"whomToMeet\" : \"whomToMeet\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /visitor/{id} : get-visitor
     *
     * @param id  (required)
     * @return OK (status code 200)
     *//*
    @Operation(
            operationId = "getVisitorId",
            summary = "get-visitor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/visitor/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<PersonDetails> _getVisitorId(
            @Parameter(name = "id", description = "", required = true) @PathVariable("id") String id
    ) {
        return getVisitorId(id);
    }

    // Override this method
    default  ResponseEntity<PersonDetails> getVisitorId(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"inTime\" : \"inTime\", \"date\" : \"date\", \"reason\" : \"reason\", \"whomToMeet\" : \"whomToMeet\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }*/

    /**
     * GET /visitor/{id} : get-visitor
     *
     * @param id  (required)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getVisitorId",
            summary = "get-visitor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = VisitorInfo.class))
                    })
            }
    )
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/visitor/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<VisitorInfo> _getVisitorId(
            @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id
    ) {
        return getVisitorId(id);
    }

    // Override this method
    default  ResponseEntity<VisitorInfo> getVisitorId(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"inTime\" : \"inTime\", \"date\" : \"date\", \"reason\" : \"reason\", \"whomToMeet\" : \"whomToMeet\", \"mobileNumber\" : \"mobileNumber\", \"name\" : \"name\", \"photo\" : \"photo\", \"id\" : \"id\", \"outTime\" : \"outTime\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }



    /**
     * PATCH /visitor/new : update-visitor
     *
     * @param personDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "patchVisitorNew",
            summary = "update-visitor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/visitor/new",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> _patchVisitorNew(
            @Parameter(name = "PersonDetails", description = "") @Valid @RequestBody(required = false) PersonDetails personDetails
    ) {
        return patchVisitorNew(personDetails);
    }

    // Override this method
    default  ResponseEntity<Void> patchVisitorNew(PersonDetails personDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


   /**
     * POST /visitor/new : new-visitor
     *
     *
     * @param personDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "postVisitorNew",
            summary = "new-visitor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/visitor/new",
            consumes = { "application/json","multipart/form-data" }
    )
    default ResponseEntity<Void> _postVisitorNew(
            @Parameter(name = "PersonDetails", description = "") @Valid @RequestBody(required = false) PersonDetails personDetails
            ) {
        return postVisitorNew(personDetails);
    }

    // Override this method
    default  ResponseEntity<Void> postVisitorNew(PersonDetails personDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /visitor/new : new-visitor
     *
     *
     * @param //personDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "postVisitorNew",
            summary = "new-visitor",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/visitor/new",
            //consumes = { "application/json","multipart/form-data" }
            consumes = { "multipart/form-data" }
    )
    default ResponseEntity<Void> _postVisitorNew(
            @RequestParam("image") MultipartFile file
    ) {
        return postVisitorNew(file);
    }

    // Override this method
    default  ResponseEntity<Void> postVisitorNew(MultipartFile file) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
