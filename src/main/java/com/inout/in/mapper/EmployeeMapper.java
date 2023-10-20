package com.inout.in.mapper;

import com.inout.in.entity.EmployeeInfo;
import com.inout.in.generateddomain.service.dto.EmployeeDetails;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeMapper {


    public static EmployeeInfo getEmployeeInfoDTO (EmployeeDetails employeeDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(EmployeeDetails.class, EmployeeInfo.class);
        EmployeeInfo employeeInfo = mapper.map(employeeDetails,EmployeeInfo.class);
        //employeeInfo.setId(UUID.randomUUID().toString());
        employeeInfo.setOutTime(" ");
        employeeInfo.setCreatedOn(new Date(Timestamp.valueOf(LocalDateTime.now()).getTime()));
        return employeeInfo;
    }

    public static EmployeeDetails getEmployeeDetails (EmployeeInfo employeeInfo) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(EmployeeInfo.class, EmployeeDetails.class);
        EmployeeDetails employeeDetails = mapper.map(employeeInfo,EmployeeDetails.class);
        return employeeDetails;
    }
}
