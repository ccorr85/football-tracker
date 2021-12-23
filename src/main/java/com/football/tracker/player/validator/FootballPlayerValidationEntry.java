package com.football.tracker.player.validator;

public class FootballPlayerValidationEntry {

    private String invalidFieldName;
    private String invalidFieldReason;


    public FootballPlayerValidationEntry(String invalidFieldName, String invalidFieldReason) {
        this.invalidFieldName = invalidFieldName;
        this.invalidFieldReason = invalidFieldReason;
    }

    public String getInvalidFieldName() {
        return invalidFieldName;
    }

    public String getInvalidFieldReason() {
        return invalidFieldReason;
    }
}
