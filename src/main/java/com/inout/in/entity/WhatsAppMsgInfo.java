package com.inout.in.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "whatsapp_details")
@Data
public class WhatsAppMsgInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "whatsapp_number")
    private String whatsappNumber;
}
