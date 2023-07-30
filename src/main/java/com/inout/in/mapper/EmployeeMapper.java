package com.inout.in.mapper;

import com.inout.in.entity.EmployeeInfo;
import com.inout.in.entity.VisitorInfo;
import com.inout.in.generateddomain.service.dto.EmployeeDetails;
import com.inout.in.generateddomain.service.dto.PersonDetails;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.util.UUID;

public class EmployeeMapper {


    public static EmployeeInfo getEmployeeInfoDTO (EmployeeDetails employeeDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(EmployeeDetails.class, EmployeeInfo.class);
        EmployeeInfo employeeInfo = mapper.map(employeeDetails,EmployeeInfo.class);
        employeeInfo.setId(UUID.randomUUID().toString());
        /*Blob blob = new SerialBlob(employeeDetails.getPhoto());
        employeeInfo.setPhoto();*/

        //employeeInfo.setPhoto(employeeInfo.getPhoto());
        employeeInfo.setOutTime(" ");
        return employeeInfo;
    }

    public static EmployeeDetails getEmployeeDetails (EmployeeInfo employeeInfo) {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(EmployeeInfo.class, EmployeeDetails.class);
        EmployeeDetails employeeDetails = mapper.map(employeeInfo,EmployeeDetails.class);
        return employeeDetails;
    }
}
