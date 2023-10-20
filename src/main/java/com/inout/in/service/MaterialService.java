package com.inout.in.service;

import com.inout.in.entity.ExitMaterialInfo;
import com.inout.in.entity.MaterialInfo;
import com.inout.in.generateddomain.service.dto.MaterialDetails;
import com.inout.in.mapper.MaterialMapper;
import com.inout.in.repository.ExitMaterialRepository;
import com.inout.in.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialService implements IMaterialService{

    @Autowired
    private MaterialRepository repository;

    @Autowired
    private ExitMaterialRepository exitrepository;

    private Logger log = LoggerFactory.getLogger(MaterialService.class);


    public List<MaterialDetails> getMaterialAll(String startDate, String endDate){

        String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        Date startDate1=new Date();
        Date endDate1=new Date();

        try {
            startDate1 = sdf.parse(startDate);
            endDate1 = sdf.parse(endDate);
            log.info("Start Date : "+startDate1+" End Date : "+endDate1);
        } catch (ParseException e) {
            //e.printStackTrace();
            log.info("Error While Fetching Material Data.....");
        }

        log.info("Start Date : "+startDate + " End Date : "+endDate);
        List<MaterialDetails> materialList = repository.findByCreatedOnBetween(startDate1, endDate1).get().stream()
                .map(data -> MaterialMapper.getMaterialDetails(data))
                .collect(Collectors.toList());
        log.info(materialList.size() + " Material Records Returned...");
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

//---------------------Exit Material


    public List<ExitMaterialInfo> getExitMaterialAll(String startDate, String endDate){

        String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        Date startDate1=new Date();
        Date endDate1=new Date();

        try {
            startDate1 = sdf.parse(startDate);
            endDate1 = sdf.parse(endDate);
            log.info("Start Date : "+startDate1+" End Date : "+endDate1);
        } catch (ParseException e) {
            //e.printStackTrace();
            log.info("Error While Fetching Material Data.....");
        }

        log.info("Start Date : "+startDate + " End Date : "+endDate);

        List<ExitMaterialInfo> materialList = exitrepository.findByCreatedOnBetween(startDate1, endDate1).get();
        log.info(materialList.size() + " Exit Material Records Returned...");
        log.info("Exit Material Details Fetched Successfully.....");
        return materialList;
    }

    public List<ExitMaterialInfo> getExitMaterialLatest(){
        List<ExitMaterialInfo> materialList = exitrepository.findTop30ByOrderByIdDesc();
        log.info("Latest Exit Material Details Fetched Successfully.....");
        return materialList;
    }

    public int getExitMaterialLatestId(){
        ExitMaterialInfo info = exitrepository.findTop1ByOrderByIdDesc();
        return info.getId().intValue();
    }

    public void postExitMaterial(ExitMaterialInfo materialDetails){
        materialDetails.setCreatedOn(new Date(Timestamp.valueOf(LocalDateTime.now()).getTime()));
        exitrepository.save(materialDetails);
        log.info("Exit Material Details Added Successfully.....(Service)");
    }

    @Transactional
    public int deleteExitMaterialId(ExitMaterialInfo materialDetails){
        int count = Math.toIntExact(exitrepository.removeByPickupPersonNameAndOutTime(materialDetails.getPickupPersonName(), materialDetails.getOutTime()));
        if(count>=1){
            log.info("Exit Material Deleted Successfully.....");
            return count;
        }
        else
        {
            log.info("Something Went Wrong..");
        }
        return 0;
    }
}
