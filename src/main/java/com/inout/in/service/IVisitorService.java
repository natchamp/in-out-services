package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.PersonDetails;

import java.time.LocalDateTime;
import java.util.List;

public interface IVisitorService {
    List<PersonDetails> getVisitorAll(String starDate, String endDate);

    List<PersonDetails> getVisitorLatest();

    int getVisitorLatestId();

    PersonDetails getVisitorId(Long id);

    void patchVisitorNew(PersonDetails personDetails);

    void createVisitor(PersonDetails personDetails);
}
