package com.inout.in.service;

import com.inout.in.entity.VisitorInfo;
import com.inout.in.generateddomain.service.dto.PersonDetails;
import com.inout.in.mapper.VisitorMapper;
import com.inout.in.repository.VisitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitorService implements IVisitorService{
    @Autowired
    private VisitorRepository repository;

    private Logger log = LoggerFactory.getLogger(VisitorService.class);

    @Override
    public List<PersonDetails> getVisitorAll() {
        List<PersonDetails> visitorList = repository.findAll().stream()
                .map(data -> VisitorMapper.getPersonDetails(data))
                .collect(Collectors.toList());
        return  visitorList;
    }

    @Override
    public PersonDetails getVisitorId(String id) {
        return null;
    }

    public VisitorInfo getVisitor(String id) {
        Optional<VisitorInfo> visitorInfo = repository.findById(id);
        return visitorInfo.get();
    }

    @Transactional
    @Override
    public void patchVisitorNew(PersonDetails personDetails) {
        //int count = repository.updateOutTime(personDetails.getName(), personDetails.getInTime(), LocalDateTime.now().toString());
//        if(count>0)
//        {
//            log.info("User Out Successfully.");
//        }

        Optional<VisitorInfo> info = repository.findByNameAndInTime(personDetails.getName(), personDetails.getInTime())
                .map(data ->{
                    data.setOutTime(LocalDateTime.now().toString());
                    return data;
                });

        log.info("Out Time - "+info.get().getOutTime());
    }

    @Override
    public void createVisitor(PersonDetails personDetails) {
        VisitorInfo visitorInfo = null;
        visitorInfo = VisitorMapper.getVisitorInfoDTO(personDetails);
        repository.save(visitorInfo);
        log.info("Visitor Added Successfully.....(Service)");
    }

  /*  public void createVisitor(MultipartFile file) {
        VisitorInfo visitorInfo = null;
        try {
            visitorInfo = VisitorMapper.getVisitorInfoDTO(new PersonDetails(), file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.save(visitorInfo);
    }*/
}
