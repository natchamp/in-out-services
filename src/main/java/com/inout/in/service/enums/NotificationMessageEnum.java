package com.inout.in.service.enums;

public enum NotificationMessageEnum {
    VISITOR_MESSAGE("visitor"),
    MATERIAL_MESSAGE("material");


    private final String message;

    private NotificationMessageEnum (String message){
        this.message=message;
    }

}
