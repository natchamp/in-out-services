package com.inout.in.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee_info")
@Data
public class EmployeeInfo {

    @Id
    private String id;

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
}
