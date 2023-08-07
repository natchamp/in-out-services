package com.inout.in.repository;

import com.inout.in.entity.WhatsAppMsgInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhatsAppMsgRepository extends JpaRepository<WhatsAppMsgInfo, String> {
    Optional<WhatsAppMsgInfo> findByName(String name);
}
