package com.inout.in.service;

import com.inout.in.entity.EmployeeInfo;
import com.inout.in.entity.MaterialInfo;
import com.inout.in.generateddomain.service.dto.MaterialDetails;
import com.inout.in.mapper.MaterialMapper;
import com.inout.in.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialService implements IMaterialService{

    @Autowired
    private MaterialRepository repository;

    private Logger log = LoggerFactory.getLogger(MaterialService.class);


    public List<MaterialDetails> getMaterialAll(){
        List<MaterialDetails> materialList = repository.findAll().stream()
                .map(data -> MaterialMapper.getMaterialDetails(data))
                .collect(Collectors.toList());
        log.info("Material Details Fetched Successfully.....");
        return materialList;
    }

    public MaterialDetails getMaterialId(String id){
        return null;
    }

    @Transactional
    public void patchMaterialNew(MaterialDetails materialDetails){
        Optional<MaterialInfo> info = repository.findByDriverNameAndInTime(materialDetails.getDriverName(), materialDetails.getInTime())
                .map(data ->{
                    data.setOutTime(LocalDateTime.now().toString());
                    return data;
                });

        log.info("Delivery Time - "+info.get().getOutTime());
    }

    public void postMaterialNew(MaterialDetails materialDetails){
        MaterialInfo materialInfo = MaterialMapper.getMaterialInfoDTO(materialDetails);
        repository.save(materialInfo);
        log.info("Material Details Added Successfully.....(Service)");
    }
}
