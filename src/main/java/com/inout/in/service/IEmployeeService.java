package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.EmployeeDetails;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDetails> getEmployeeAll(String startDate, String endDate);

    List<EmployeeDetails> getEmployeeAllLatest();

    EmployeeDetails getEmployeeId(Long id);

    void patchEmployeeNew(EmployeeDetails employeeDetails);

    void postEmployeeNew(EmployeeDetails employeeDetails);

    int latestEmployeeId();
}
