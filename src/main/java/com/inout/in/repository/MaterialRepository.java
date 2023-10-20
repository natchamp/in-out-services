package com.inout.in.repository;

import com.inout.in.entity.MaterialInfo;
import com.inout.in.entity.VisitorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialInfo, Long>{
    Optional<MaterialInfo> findByDriverNameAndInTime(String driverName, String inTime);

    Long removeByDriverNameAndInTime(String driverName, String inTime);

    List<MaterialInfo> findTop30ByOrderByIdDesc();

    MaterialInfo findTop1ByOrderByIdDesc();

    Optional<List<MaterialInfo>> findByCreatedOnBetween(Date startCreatedOn, Date endCreatedOn);
}
