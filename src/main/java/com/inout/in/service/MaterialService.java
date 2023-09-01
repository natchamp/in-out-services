package com.inout.in.service;

import com.inout.in.entity.MaterialInfo;
import com.inout.in.generateddomain.service.dto.MaterialDetails;
import com.inout.in.mapper.MaterialMapper;
import com.inout.in.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<MaterialDetails> getMaterialLatest(){
        List<MaterialDetails> materialList = repository.findTop30ByOrderByIdDesc().stream()
                .map(data -> MaterialMapper.getMaterialDetails(data))
                .collect(Collectors.toList());
        log.info("Material Details Fetched Successfully.....");
        return materialList;
    }

    public int getMaterialLatestId(){
        MaterialInfo info = repository.findTop1ByOrderByIdDesc();

        return info.getId().intValue();
    }

    public MaterialDetails getMaterialId(Long id){
        return null;
    }

    @Transactional
    public void patchMaterialNew(MaterialDetails materialDetails){
        Optional<MaterialInfo> info = repository.findByDriverNameAndInTime(materialDetails.getDriverName(), materialDetails.getInTime())
                .map(data ->{
                    data.setOutTime(materialDetails.getOutTime());
                    return data;
                });

        log.info("Delivery Time - "+info.get().getOutTime());
    }

    public void postMaterialNew(MaterialDetails materialDetails){
        MaterialInfo materialInfo = MaterialMapper.getMaterialInfoDTO(materialDetails);
        repository.save(materialInfo);
        log.info("Material Details Added Successfully.....(Service)");
    }

    @Transactional
    public int deleteMaterialId(MaterialDetails materialDetails){
        int count = Math.toIntExact(repository.removeByDriverNameAndInTime(materialDetails.getDriverName(), materialDetails.getInTime()));
        if(count>=1){
            log.info("Material Deleted Successfully.....");
            return count;
        }
        else
        {
            log.info("Something Went Wrong..");
        }
        return 0;
    }
}
