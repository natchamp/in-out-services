package com.inout.in.web;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.inout.in.entity.VisitorInfo;
import com.inout.in.generateddomain.service.dto.PersonDetails;
import com.inout.in.service.VisitorService;
import com.inout.in.web.api.VisitorApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class VisitorController implements VisitorApi {

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @Autowired
    private VisitorService visitorService;
    private String topic = "arn:aws:sns:ap-south-1:428167789260:visitor-info";

    private Logger log = LoggerFactory.getLogger(VisitorController.class);

    @Override
    public ResponseEntity<List<PersonDetails>> getVisitorAll() {
        /*SubscribeRequest request = new SubscribeRequest(topic,"email","rohitkhade7010@gmail.com");
        amazonSNSClient.subscribe(request);*/

       /* PublishRequest request = new PublishRequest(topic,"Welcome To Inn Techmics PVT LTD. \n Regards,\nDiector",
                "Welcome");
        amazonSNSClient.publish(request);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);*/

        List<PersonDetails> visitorList = visitorService.getVisitorAll();
        log.info("Visitor List Returned Successfully.....");
        return new ResponseEntity<>(visitorList, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<PersonDetails>> getVisitorLatest() {
        List<PersonDetails> visitorList = visitorService.getVisitorLatest();
        log.info("Visitor List Returned Successfully.....");
        return new ResponseEntity<>(visitorList, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> getVisitorLatestId() {
        int id = visitorService.getVisitorLatestId();
        log.info("Visitor ID : "+id);
        return new ResponseEntity<>(String.valueOf(id), HttpStatus.OK);

    }

    /*public ResponseEntity<PersonDetails> getVisitorId(String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }*/

    @Override
    public ResponseEntity<VisitorInfo> getVisitorId(Long id) {
        VisitorInfo visitorInfo = visitorService.getVisitor(id);
        return new ResponseEntity<>(visitorInfo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> patchVisitorNew(PersonDetails personDetails) {
        visitorService.patchVisitorNew(personDetails);
        log.info("Visitor Out Successfully...");
        return new ResponseEntity("Visitor Out Successfully...", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postVisitorNew(PersonDetails personDetails) {
        visitorService.createVisitor(personDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteVisitor(PersonDetails personDetails) {

        if(visitorService.deleteVisitor(personDetails) >=1)
        {
            return new ResponseEntity("Visitor Deleted Successfully...", HttpStatus.OK);
        }

        return new ResponseEntity("Error While Deleting Visitor...", HttpStatus.OK);
    }

}
