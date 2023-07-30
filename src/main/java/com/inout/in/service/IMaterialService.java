package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.MaterialDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMaterialService {

    List<MaterialDetails> getMaterialAll();

    MaterialDetails getMaterialId(String id);

    void patchMaterialNew(MaterialDetails materialDetails);

    void postMaterialNew(MaterialDetails materialDetails);
}
