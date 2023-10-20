package com.inout.in.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="visitor_info")
@Data
public class VisitorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Lob
    @Column(name = "photo")
    private String photo;

    @Column(name = "created_on")
    private Date createdOn;
}
