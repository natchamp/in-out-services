package com.inout.in.repository;

import com.inout.in.entity.ExitMaterialInfo;
import com.inout.in.entity.VisitorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExitMaterialRepository extends JpaRepository<ExitMaterialInfo, Long> {

    Optional<ExitMaterialInfo> findByPickupPersonNameAndOutTime(String pickupPersonName, String outTime);

    Long removeByPickupPersonNameAndOutTime(String pickupPersonName, String outTime);

    List<ExitMaterialInfo> findTop30ByOrderByIdDesc();

    ExitMaterialInfo findTop1ByOrderByIdDesc();

    Optional<List<ExitMaterialInfo>> findByCreatedOnBetween(Date startCreatedOn, Date endCreatedOn);
}
