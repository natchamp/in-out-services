package com.inout.in.repository;

import com.inout.in.entity.RegistrationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RegistrationInfo, Long> {

    //@Query("select count(*) from user_info where email=?1")
    long countByEmail(String email);

    long countByEmailAndPassword(String email, String password);

    RegistrationInfo findByEmailAndPassword(String email, String password);
    RegistrationInfo findByEmail(String email);
}
