package com.inout.in.mapper;

import com.inout.in.entity.MaterialInfo;
import com.inout.in.generateddomain.service.dto.MaterialDetails;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class MaterialMapper {

    public static MaterialInfo getMaterialInfoDTO (MaterialDetails materialDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(MaterialDetails.class, MaterialInfo.class);
        MaterialInfo materialInfo = mapper.map(materialDetails,MaterialInfo.class);
        //materialInfo.setId(UUID.randomUUID().toString());
        materialInfo.setCreatedOn(new Date(Timestamp.valueOf(LocalDateTime.now()).getTime()));
        return materialInfo;
    }

    public static MaterialDetails getMaterialDetails (MaterialInfo materialInfo) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(MaterialInfo.class, MaterialDetails.class);
        MaterialDetails materialDetails = mapper.map(materialInfo,MaterialDetails.class);
        return materialDetails;
    }


}
