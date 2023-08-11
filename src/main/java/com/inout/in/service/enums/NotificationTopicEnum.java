package com.inout.in.service.enums;

public enum NotificationTopicEnum {
    ADMIN("admin"),
    ALL("all"),
    MANAGER("manager");

    public final String topic;
    private NotificationTopicEnum(String topic) {
        this.topic = topic;
    }
}
