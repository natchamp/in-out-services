package com.inout.in.service;

import com.inout.in.entity.WhatsAppMsgInfo;
import com.inout.in.repository.WhatsAppMsgRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WhatsAppMsgService {

    private Logger log = LoggerFactory.getLogger(WhatsAppMsgService.class);
    @Autowired
    private WhatsAppMsgRepository repository;

    public void sendWhatsappMessage(String name, String visitorName){
        try {
            WhatsAppMsgInfo info = repository.findByName(name).get();

            Twilio.init("AC2a136737bbb82d378f0008350170f977", "195b5b1118b5e032426ac0f9c2efd295");

            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+91" + info.getWhatsappNumber()),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), getMessageBody(info.getName(), visitorName)).create();
            log.info("Whatsapp Message Sent Successfully.. Name : {} Number : {}", name, info.getWhatsappNumber());
            //log.info("Whatsapp Message Sent Successfully. Number - "+info.getWhatsappNumber());
        }
        catch (NoSuchElementException e)
        {
            log.info("Unable to Send Whatsapp Message. Number Not Available");
        }
    }

    public String getMessageBody(String name, String visitorName){
        String message = String.format("Hi,%s \n%s has come to meet you.\n Kindly send your your confirmation. \n\nRegards, \nReception\nInnovative Technomics ",name,visitorName);
        log.info(message);
        return message;
    }
}
