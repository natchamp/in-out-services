package com.inout.in.repository;

import com.inout.in.entity.EmployeeInfo;
import com.inout.in.entity.VisitorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {
    Optional<EmployeeInfo> findByNameAndInTime(String name, String inTime);

    Long removeByNameAndInTime(String name, String inTime);

    List<EmployeeInfo> findTop30ByOrderByIdDesc();

    EmployeeInfo findTop1ByOrderByIdDesc();

    Optional<List<EmployeeInfo>> findByCreatedOnBetween(Date startCreatedOn, Date endCreatedOn);
}
