package com.inout.in.web;

import com.inout.in.generateddomain.service.dto.MaterialDetails;
import com.inout.in.service.MaterialService;
import com.inout.in.web.api.MaterialApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MaterialController implements MaterialApi {

    @Autowired
    private MaterialService materialService;

    private Logger log = LoggerFactory.getLogger(MaterialController.class);

    public ResponseEntity<List<MaterialDetails>> getMaterialAll() {
        List<MaterialDetails> materialList = materialService.getMaterialAll();
        log.info("Material Details Returned Successfully.....");
        return new ResponseEntity<>(materialList, HttpStatus.OK);
    }

    public ResponseEntity<MaterialDetails> getMaterialId(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patchMaterialNew(MaterialDetails materialDetails) {
        materialService.patchMaterialNew(materialDetails);
        log.info("Material Delivered Successfully...");
        return new ResponseEntity("Material Delivered Successfully...", HttpStatus.OK);

    }

    public ResponseEntity<Void> postMaterialNew(MaterialDetails materialDetails) {
        materialService.postMaterialNew(materialDetails);
        log.info("Material Details Added Successfully.....");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}