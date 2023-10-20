package com.inout.in.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="exit_material_info")
@Data
public class ExitMaterialInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pickupPersonName")
    private String pickupPersonName;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "materialDescription")
    private String materialDescription;

    @Lob
    @Column(name = "materialDocument")
    private String materialDocument;

    @JsonProperty("vehicleNumber")
    private String vehicleNumber;

    @Column(name = "outTime")
    private String outTime;

    @Column(name = "date")
    private String date;

    @Lob
    @Column(name ="photo")
    private String photo;

    @Column(name = "created_on")
    private Date createdOn;
}
