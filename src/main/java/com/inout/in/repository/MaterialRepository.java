package com.inout.in.repository;

import com.inout.in.entity.MaterialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialInfo, Long>{
    Optional<MaterialInfo> findByDriverNameAndInTime(String driverName, String inTime);

    Long removeByDriverNameAndInTime(String driverName, String inTime);
}
