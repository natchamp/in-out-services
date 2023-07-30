package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.EmployeeDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDetails> getEmployeeAll();

    EmployeeDetails getEmployeeId(String id);

    void patchEmployeeNew(EmployeeDetails employeeDetails);

    void postEmployeeNew(EmployeeDetails employeeDetails);
}
