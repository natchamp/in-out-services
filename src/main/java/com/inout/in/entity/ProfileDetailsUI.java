package com.inout.in.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;

@Data
public class ProfileDetailsUI {

    @JsonProperty("name")
    private String name;
    @JsonProperty("reason")
    private String reason;

    @JsonProperty("whomToMeet")
    private String whomToMeet;
    @JsonProperty("inTime")
    private String inTime;
    @JsonProperty("outTime")
    private String outTime;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("date")
    private String date;
    @JsonProperty("extra")
    private String extra;
    @JsonProperty("photo")
    private String photo;

}
