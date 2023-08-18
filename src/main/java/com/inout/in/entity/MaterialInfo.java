package com.inout.in.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="material_info")
@Data
public class MaterialInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicleNumber")
    private String vehicleNumber;

    @Column(name = "driverName")
    private String driverName;

    @Column(name = "materialDescription")
    private String materialDescription;

    @Lob
    @Column(name = "materialDocument")
    private String materialDocument;

    @Column(name = "inTime")
    private String inTime;

    @Column(name = "outTime")
    private String outTime;

    @Column(name = "date")
    private String date;

    @Lob
    @Column(name ="photo")
    private String photo;
}
