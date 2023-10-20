package com.inout.in.web;

import com.inout.in.entity.ExitMaterialInfo;
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

    @Override
    public ResponseEntity<List<MaterialDetails>> getMaterialAll(String startDate, String endDate) {
        List<MaterialDetails> materialList = materialService.getMaterialAll(startDate, endDate);
        log.info("Material Details Returned Successfully.....");
        return new ResponseEntity<>(materialList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MaterialDetails>> getMaterialLatest() {
        List<MaterialDetails> materialList = materialService.getMaterialLatest();
        log.info("Material Details Returned Successfully.....");
        return new ResponseEntity<>(materialList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getMaterialLatestId() {
        int id = materialService.getMaterialLatestId();
        log.info("Material ID : "+id);
        return new ResponseEntity<>(String.valueOf(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MaterialDetails> getMaterialId(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> patchMaterialNew(MaterialDetails materialDetails) {
        materialService.patchMaterialNew(materialDetails);
        log.info("Material Delivered Successfully...");
        return new ResponseEntity("Material Delivered Successfully...", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Void> postMaterialNew(MaterialDetails materialDetails) {
        materialService.postMaterialNew(materialDetails);
        log.info("Material Details Added Successfully.....");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteMaterialId(MaterialDetails materialDetails) {
        if(materialService.deleteMaterialId(materialDetails) >=1)
        {
            return new ResponseEntity("Material Deleted Successfully...", HttpStatus.OK);
        }

        return new ResponseEntity("Error While Deleting Material...", HttpStatus.OK);
    }

    //==========Material Exit

    @Override
    public ResponseEntity<Void> deleteExitMaterialId(ExitMaterialInfo materialDetails) {
        if(materialService.deleteExitMaterialId(materialDetails) >=1)
        {
            return new ResponseEntity("Exit Material Deleted Successfully...", HttpStatus.OK);
        }

        return new ResponseEntity("Error While Deleting Exit Material...", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<ExitMaterialInfo>> getExitMaterialLatest() {
        List<ExitMaterialInfo> materialList = materialService.getExitMaterialLatest();
        log.info("Latest Exit Material Details Returned Successfully.....");
        return new ResponseEntity<>(materialList, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Void> postExitMaterial(ExitMaterialInfo materialDetails) {
        materialService.postExitMaterial(materialDetails);
        log.info("Exit Material Details Added Successfully.....");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> getExitMaterialLatestId() {
        int id = materialService.getExitMaterialLatestId();
        log.info("Exit Material ID : "+id);
        return new ResponseEntity<>(String.valueOf(id), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<ExitMaterialInfo>> getExitMaterialAll(String startDate, String endDate) {
        List<ExitMaterialInfo> materialList = materialService.getExitMaterialAll(startDate, endDate);
        log.info("Exit Material Details Returned Successfully.....");
        return new ResponseEntity<>(materialList, HttpStatus.OK);
    }

}
