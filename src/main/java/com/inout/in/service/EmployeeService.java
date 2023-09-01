package com.inout.in.service;

import com.inout.in.entity.EmployeeInfo;
import com.inout.in.generateddomain.service.dto.EmployeeDetails;
import com.inout.in.mapper.EmployeeMapper;
import com.inout.in.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public List<EmployeeDetails> getEmployeeAll(){

        List<EmployeeDetails> employeeList = repository.findAll().stream()
                .map(data -> EmployeeMapper.getEmployeeDetails(data))
                .collect(Collectors.toList());

        log.info("Employee List Fetched Successfully.....");

        return employeeList;
    }

    public List<EmployeeDetails> getEmployeeAllLatest(){

        List<EmployeeDetails> employeeList = repository.findTop30ByOrderByIdDesc().stream()
                .map(data -> EmployeeMapper.getEmployeeDetails(data))
                .collect(Collectors.toList());

        log.info("Employee List Fetched Successfully.....");

        return employeeList;
    }

    public int latestEmployeeId(){
        EmployeeInfo info = repository.findTop1ByOrderByIdDesc();
        return info.getId().intValue();
    }

    public EmployeeDetails getEmployeeId(Long id){
        EmployeeInfo employeeInfo = repository.getReferenceById(id);
        log.info("Employee Date Fetched Successfully. Name - {}",employeeInfo.getName());
        return EmployeeMapper.getEmployeeDetails(employeeInfo);
    }

    @Transactional
    public void patchEmployeeNew(EmployeeDetails employeeDetails){
        Optional<EmployeeInfo> info = repository.findByNameAndInTime(employeeDetails.getName(), employeeDetails.getInTime())
                .map(data ->{
                    data.setOutTime(employeeDetails.getOutTime());
                    return data;
                });

        log.info("Out Time - "+info.get().getOutTime());

    }

    public void postEmployeeNew(EmployeeDetails employeeDetails){
        EmployeeInfo employeeInfo = EmployeeMapper.getEmployeeInfoDTO(employeeDetails);
        repository.save(employeeInfo);
        log.info("Employee Data Added Successfully....");
    }


    @Transactional
    public int deleteEmployee(EmployeeDetails employeeDetails){

        int count = Math.toIntExact(repository.removeByNameAndInTime(employeeDetails.getName(), employeeDetails.getInTime()));
        if(count>=1){
            log.info("Employee Deleted Successfully.....");
            return count;
        }
        else
        {
            log.info("Something Went Wrong..");
        }
        return 0;
    }
}
