package com.football.tracker.player.validator;

import com.football.tracker.player.entity.FootballPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.football.tracker.player.FootballPlayerFieldNameEnum.*;

public class FootballPlayerValidator {
    public static final String FIELD_MISSING_MESSAGE = "Field is missing or empty";

    public List<FootballPlayerValidationEntry> validateFootballPlayer(FootballPlayer footballPlayer) {
        List<FootballPlayerValidationEntry> validationEntryList = new ArrayList<>();

        validationEntryList.addAll(areNameDetailsValid(footballPlayer));
        validationEntryList.addAll(areContactDetailsValid(footballPlayer));

        return validationEntryList;
    }

    private List<FootballPlayerValidationEntry> areNameDetailsValid(FootballPlayer footballPlayer) {
        List<FootballPlayerValidationEntry> validationEntryList = new ArrayList<>();

        FootballPlayerValidationEntry firstNameValidationEntry = validateFieldValue(footballPlayer.getFirstName(),
                FIRST_NAME.getFieldName());
        FootballPlayerValidationEntry lastNameValidationEntry = validateFieldValue(footballPlayer.getLastName(),
                LAST_NAME.getFieldName());

        if (firstNameValidationEntry != null) {
            validationEntryList.add(firstNameValidationEntry);
        }

        if (lastNameValidationEntry != null) {
            validationEntryList.add(lastNameValidationEntry);
        }
        return validationEntryList;
    }

    private List<FootballPlayerValidationEntry> areContactDetailsValid(FootballPlayer footballPlayer) {
        List<FootballPlayerValidationEntry> validationEntryList = new ArrayList<>();

        FootballPlayerValidationEntry emailAddressValidationEntry = validateFieldValue(footballPlayer.getEmailAddress(),
                EMAIL_ADDRESS.getFieldName());
        FootballPlayerValidationEntry phoneNumberValidationEntry = validateFieldValue(footballPlayer.getPhoneNumber(),
                PHONE_NUMBER.getFieldName());

        if (emailAddressValidationEntry != null) {
            validationEntryList.add(emailAddressValidationEntry);
        }

        if (phoneNumberValidationEntry != null) {
            validationEntryList.add(phoneNumberValidationEntry);
        }
        return validationEntryList;
    }

    private FootballPlayerValidationEntry validateFieldValue(String fieldValue, String fieldName) {
        FootballPlayerValidationEntry footballPlayerValidationEntry = null;
        if (fieldValue == null || fieldValue.length() == 0) {
            footballPlayerValidationEntry = new FootballPlayerValidationEntry(fieldName, FIELD_MISSING_MESSAGE);
        }
        return footballPlayerValidationEntry;
    }
}
