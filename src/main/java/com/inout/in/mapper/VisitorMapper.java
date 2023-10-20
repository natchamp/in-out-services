package com.inout.in.mapper;

import com.inout.in.entity.VisitorInfo;
import com.inout.in.generateddomain.service.dto.PersonDetails;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class VisitorMapper {

    public static VisitorInfo getVisitorInfoDTO (PersonDetails personDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(PersonDetails.class, VisitorInfo.class);
        VisitorInfo visitorInfo = mapper.map(personDetails,VisitorInfo.class);
        //visitorInfo.setId(UUID.randomUUID().toString());
        visitorInfo.setCreatedOn(new Date(Timestamp.valueOf(LocalDateTime.now()).getTime()));
        return visitorInfo;
    }

    public static PersonDetails getPersonDetails (VisitorInfo visitorInfo) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(VisitorInfo.class, PersonDetails.class);
        PersonDetails personDetails = mapper.map(visitorInfo,PersonDetails.class);
        return personDetails;
    }
}
