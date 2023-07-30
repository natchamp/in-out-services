package com.inout.in.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="visitor_info")
@Data
public class VisitorInfo {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "reason")
    private String reason;

    @Column(name = "whomToMeet")
    private String whomToMeet;

    @Column(name = "inTime")
    private String inTime;

    @Column(name = "outTime")
    private String outTime;

    @Column(name = "date")
    private String date;

   /* @Column(name = "image", length = 1000)
    private byte[] image;*/

    @Lob
    @Column(name = "photo")
    private String photo;
}
