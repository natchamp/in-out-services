package com.inout.in.service;

import com.inout.in.generateddomain.service.dto.PersonDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IVisitorService {
    List<PersonDetails> getVisitorAll();

    PersonDetails getVisitorId(String id);

    void patchVisitorNew(PersonDetails personDetails);

    void createVisitor(PersonDetails personDetails);
}
