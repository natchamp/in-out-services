package com.inout.in.repository;

import com.inout.in.entity.MaterialInfo;
import com.inout.in.entity.VisitorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialInfo, String>{
    Optional<MaterialInfo> findByDriverNameAndInTime(String driverName, String inTime);
}
