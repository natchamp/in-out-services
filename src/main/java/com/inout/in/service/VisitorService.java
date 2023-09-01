package com.inout.in.service;

import com.inout.in.entity.VisitorInfo;
import com.inout.in.generateddomain.service.dto.MaterialDetails;
import com.inout.in.generateddomain.service.dto.PersonDetails;
import com.inout.in.mapper.VisitorMapper;
import com.inout.in.repository.VisitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitorService implements IVisitorService{
    @Autowired
    private VisitorRepository repository;

    @Autowired
    private WhatsAppMsgService whatsAppMsgService;

    private Logger log = LoggerFactory.getLogger(VisitorService.class);

    @Override
    public List<PersonDetails> getVisitorAll() {
        List<PersonDetails> visitorList = repository.findAll().stream()
                .map(data -> VisitorMapper.getPersonDetails(data))
                .collect(Collectors.toList());
        return  visitorList;
    }

    @Override
    public List<PersonDetails> getVisitorLatest() {
        List<PersonDetails> visitorList = repository.findTop30ByOrderByIdDesc().stream()
                .map(data -> VisitorMapper.getPersonDetails(data))
                .collect(Collectors.toList());
        return  visitorList;
    }

    @Override
    public int getVisitorLatestId(){
        VisitorInfo info = repository.findTop1ByOrderByIdDesc();
        return info.getId().intValue();
    }

    @Override
    public PersonDetails getVisitorId(Long id) {
        return null;
    }

    public VisitorInfo getVisitor(Long id) {
        Optional<VisitorInfo> visitorInfo = repository.findById(id);
        return visitorInfo.get();
    }

    @Transactional
    @Override
    public void patchVisitorNew(PersonDetails personDetails) {

        Optional<VisitorInfo> info = repository.findByNameAndInTime(personDetails.getName(), personDetails.getInTime())
                .map(data ->{
                    data.setOutTime(personDetails.getOutTime());
                    return data;
                });

        log.info("Out Time - "+info.get().getOutTime());
    }

    @Override
    public void createVisitor(PersonDetails personDetails) {
        VisitorInfo visitorInfo = VisitorMapper.getVisitorInfoDTO(personDetails);
        repository.save(visitorInfo);

        //---------------whatsapp logic-------------
        whatsAppMsgService.sendWhatsappMessage(personDetails.getWhomToMeet(), personDetails.getName());

        //----------------------------------
        log.info("Visitor Added Successfully.....(Service)");
    }

    @Transactional
    public int deleteVisitor(PersonDetails personDetails){
        log.info("Name : "+personDetails.getName()+" InTime : "+personDetails.getInTime());
        int count = Math.toIntExact(repository.removeByNameAndInTime(personDetails.getName(), personDetails.getInTime()));
        if(count>=1){
            log.info("Visitor Deleted Successfully.....");
            return count;
        }
        else
        {
            log.info("Something Went Wrong..");
        }
        return 0;
    }

}
