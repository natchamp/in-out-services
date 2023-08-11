package com.inout.in.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@Data
public class RegistrationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "password")
    private String password;

    @Column(name = "blocked")
    private Boolean blocked;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "UserType")
    private String userType;

    @Column(name = "createOn")
    private String createOn;


}
