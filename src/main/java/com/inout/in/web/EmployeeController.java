package com.inout.in.web;

import com.inout.in.generateddomain.service.dto.EmployeeDetails;
import com.inout.in.service.EmployeeService;
import com.inout.in.web.api.EmployeeApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EmployeeController implements EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    private Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Override
    public ResponseEntity<List<EmployeeDetails>> getEmployeeAll() {
        List<EmployeeDetails> employeeList = employeeService.getEmployeeAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<EmployeeDetails> getEmployeeId(Long id) {
        EmployeeDetails employeeDetails = employeeService.getEmployeeId(id);
        log.info("Employee Data Returned Successfully...");
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> patchEmployeeNew(EmployeeDetails employeeDetails) {
        employeeService.patchEmployeeNew(employeeDetails);
        log.info("Employee Out Successfully...");
        return new ResponseEntity("Employee Out Successfully...", HttpStatus.OK);

    }

    @Override
    public  ResponseEntity<Void> postEmployeeNew(EmployeeDetails employeeDetails) {
        employeeService.postEmployeeNew(employeeDetails);
        log.info("Employee Details Added Successfully.....");
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
