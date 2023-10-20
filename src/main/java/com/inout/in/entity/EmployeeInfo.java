package com.inout.in.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_info")
@Data
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date")
    private String date;

    @Column(name = "outTime")
    private String outTime;

    @Column(name = "inTime")
    private String inTime;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Lob
    @Column(name = "photo")
    private String photo;

    @Column(name = "created_on")
    private Date createdOn;
}
