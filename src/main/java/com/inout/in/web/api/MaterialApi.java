package com.inout.in.web.api;

import com.inout.in.generateddomain.ApiUtil;
import com.inout.in.generateddomain.service.dto.MaterialDetails;
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

public interface MaterialApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /material/all : get-materials-list
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getMaterialAll",
            summary = "get-materials-list",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/material/all",
            produces = { "application/json" }
    )
    default ResponseEntity<List<MaterialDetails>> _getMaterialAll(

    ) {
        return getMaterialAll();
    }

    // Override this method
    default  ResponseEntity<List<MaterialDetails>> getMaterialAll() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"materialDocument\" : \"materialDocument\", \"inTime\" : \"inTime\", \"date\" : \"date\", \"vehicleNumber\" : \"vehicleNumber\", \"driverName\" : \"driverName\", \"id\" : \"id\", \"outTime\" : \"outTime\", \"materialDescription\" : \"materialDescription\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /material/{id} : get-material
     *
     * @param id  (required)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getMaterialId",
            summary = "get-material",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/material/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<MaterialDetails> _getMaterialId(
            @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id
    ) {
        return getMaterialId(id);
    }

    // Override this method
    default  ResponseEntity<MaterialDetails> getMaterialId(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"materialDocument\" : \"materialDocument\", \"inTime\" : \"inTime\", \"date\" : \"date\", \"vehicleNumber\" : \"vehicleNumber\", \"driverName\" : \"driverName\", \"id\" : \"id\", \"outTime\" : \"outTime\", \"materialDescription\" : \"materialDescription\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /material/new : update-material
     *
     * @param materialDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "patchMaterialNew",
            summary = "update-material",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/material/new",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> _patchMaterialNew(
            @Parameter(name = "MaterialDetails", description = "") @Valid @RequestBody(required = false) MaterialDetails materialDetails
    ) {
        return patchMaterialNew(materialDetails);
    }

    // Override this method
    default  ResponseEntity<Void> patchMaterialNew(MaterialDetails materialDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /material/new : new-material
     *
     * @param materialDetails  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "postMaterialNew",
            summary = "new-material",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/material/new",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> _postMaterialNew(
            @Parameter(name = "MaterialDetails", description = "") @Valid @RequestBody(required = false) MaterialDetails materialDetails
    ) {
        return postMaterialNew(materialDetails);
    }

    // Override this method
    default  ResponseEntity<Void> postMaterialNew(MaterialDetails materialDetails) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
