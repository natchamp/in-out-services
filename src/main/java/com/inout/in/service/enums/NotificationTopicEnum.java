package com.inout.in.service.enums;

public enum NotificationTopicEnum {
    ADMIN("admin"),
    All("all"),
    Manager("manager");

    public final String topic;
    private NotificationTopicEnum(String topic) {
        this.topic = topic;
    }
}
