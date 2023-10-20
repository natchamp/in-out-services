package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.MaterialDetails;

import java.util.List;

public interface IMaterialService {

    List<MaterialDetails> getMaterialAll(String startDate, String endDate);

    List<MaterialDetails> getMaterialLatest();

    int getMaterialLatestId();

    MaterialDetails getMaterialId(Long id);

    void patchMaterialNew(MaterialDetails materialDetails);

    void postMaterialNew(MaterialDetails materialDetails);
}
