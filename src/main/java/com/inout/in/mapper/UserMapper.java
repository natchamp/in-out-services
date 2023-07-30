package com.inout.in.mapper;

import com.inout.in.entity.MaterialInfo;
import com.inout.in.entity.RegistrationInfo;
import com.inout.in.generateddomain.service.dto.RegistrationDetails;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserMapper {

    private static Logger log = LoggerFactory.getLogger(UserMapper.class);
    public static RegistrationInfo getRegistrationInfoDTO (RegistrationDetails registrationDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(RegistrationDetails.class, MaterialInfo.class);
        RegistrationInfo registrationInfo = mapper.map(registrationDetails,RegistrationInfo.class);
        registrationInfo.setId(UUID.randomUUID().toString());
        registrationInfo.setCreateOn(LocalDateTime.now().toString());
        registrationInfo.setUserType(RegistrationDetails.UserTypeEnum.USER.toString());

        return registrationInfo;
    }

    public static RegistrationDetails getRegistrationDetails (RegistrationInfo registrationInfo) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(RegistrationInfo.class, RegistrationDetails.class);
        RegistrationDetails registrationDetails = mapper.map(registrationInfo, RegistrationDetails.class);
        return registrationDetails;
    }
}
