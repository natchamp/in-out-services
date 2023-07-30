package com.inout.in.repository;

import com.inout.in.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, String> {
    Optional<EmployeeInfo> findByNameAndInTime(String name, String inTime);
}