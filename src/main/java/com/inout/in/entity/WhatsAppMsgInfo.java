package com.inout.in.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "whatsapp_details")
@Data
public class WhatsAppMsgInfo {

    @Id
    private String Id;

    @Column(name = "name")
    private String name;

    @Column(name = "whatsapp_number")
    private String whatsappNumber;
}
