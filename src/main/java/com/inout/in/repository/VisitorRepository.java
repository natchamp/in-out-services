package com.inout.in.repository;

import com.inout.in.entity.VisitorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<VisitorInfo, Long> {

//    @Modifying
//    @Query("UPDATE in-out.visitor_info v SET v.out_time= :outTime WHERE v.name= :name AND v.inTime= :inTime")
//    int updateOutTime(@Param("name") String name, @Param("inTime") String inTime, @Param("outTime") String outTime);

    Optional<VisitorInfo> findByNameAndInTime(String name, String inTime);

    Long removeByNameAndInTime(String name, String inTime);

    List<VisitorInfo> findTop30ByOrderByIdDesc();

    VisitorInfo findTop1ByOrderByIdDesc();

    Optional<List<VisitorInfo>> findByCreatedOnBetween(Date startCreatedOn, Date endCreatedOn);
}
