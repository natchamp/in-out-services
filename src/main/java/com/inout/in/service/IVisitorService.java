package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.PersonDetails;

import java.util.List;

public interface IVisitorService {
    List<PersonDetails> getVisitorAll();

    List<PersonDetails> getVisitorLatest();

    int getVisitorLatestId();

    PersonDetails getVisitorId(Long id);

    void patchVisitorNew(PersonDetails personDetails);

    void createVisitor(PersonDetails personDetails);
}
