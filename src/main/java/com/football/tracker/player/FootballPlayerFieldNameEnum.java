package com.football.tracker.player;

public enum FootballPlayerFieldNameEnum {

    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    NICKNAME("nickname"),
    EMAIL_ADDRESS("emailAddress"),
    PHONE_NUMBER("phoneNumber");

    private final String fieldName;

    FootballPlayerFieldNameEnum(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
