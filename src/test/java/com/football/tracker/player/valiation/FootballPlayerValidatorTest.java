package com.football.tracker.player.valiation;

import com.football.tracker.player.entity.FootballPlayer;
import com.football.tracker.player.validator.FootballPlayerValidationEntry;
import com.football.tracker.player.validator.FootballPlayerValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.football.tracker.player.FootballPlayerFieldNameEnum.*;
import static com.football.tracker.player.validator.FootballPlayerValidator.FIELD_MISSING_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

public class FootballPlayerValidatorTest {

    private FootballPlayerValidator validator;
    private List<FootballPlayerValidationEntry> footballPlayerValidationEntryList;
    private FootballPlayer footballPlayer;

    @BeforeEach
    public void setup() {
        validator = new FootballPlayerValidator();
        if (footballPlayerValidationEntryList != null) {
            footballPlayerValidationEntryList.clear();
        }
        setupValidFootballPlayer();
    }

    @Test
    public void test_NullFirstName_CorrectValidationEntryReturned() {
        footballPlayer.setFirstName(null);
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(FIRST_NAME.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_EmptyFirstName_CorrectValidationEntryReturned() {
        footballPlayer.setFirstName("");
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(FIRST_NAME.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_NullLastName_CorrectValidationEntryReturned() {
        footballPlayer.setLastName(null);
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(LAST_NAME.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_EmptyLastName_CorrectValidationEntryReturned() {
        footballPlayer.setLastName("");
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(LAST_NAME.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_NullNickname_EmptyValidationEntryList() {
        footballPlayer.setNickname(null);
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertTrue(footballPlayerValidationEntryList.isEmpty());
    }

    @Test
    public void test_EmptyNickname_EmptyValidationEntryList() {
        footballPlayer.setNickname("");
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertTrue(footballPlayerValidationEntryList.isEmpty());
    }

    @Test
    public void test_NullEmailAddress_CorrectValidationEntryReturned() {
        footballPlayer.setEmailAddress(null);
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(EMAIL_ADDRESS.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_EmptyEmailAddress_CorrectValidationEntryReturned() {
        footballPlayer.setEmailAddress("");
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(EMAIL_ADDRESS.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_NullPhoneNumber_CorrectValidationEntryReturned() {
        footballPlayer.setPhoneNumber(null);
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(PHONE_NUMBER.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_EmptyPhoneNumber_CorrectValidationEntryReturned() {
        footballPlayer.setPhoneNumber("");
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertFalse(footballPlayerValidationEntryList.isEmpty());

        verifyEntryListContainsFieldNameAndMessage(PHONE_NUMBER.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    @Test
    public void test_MultipleInvalidFieldsEmptyPhoneNumber_MultipleValidationEntriesReturned() {
        footballPlayer.setPhoneNumber("");
        footballPlayer.setLastName("");
        footballPlayerValidationEntryList = validator.validateFootballPlayer(footballPlayer);
        assertEquals(2, footballPlayerValidationEntryList.size());

        verifyEntryListContainsFieldNameAndMessage(PHONE_NUMBER.getFieldName(), FIELD_MISSING_MESSAGE);
        verifyEntryListContainsFieldNameAndMessage(LAST_NAME.getFieldName(), FIELD_MISSING_MESSAGE);
    }

    private void verifyEntryListContainsFieldNameAndMessage(String fieldName, String validationErrorMessage) {
        boolean containsData = false;
         for (FootballPlayerValidationEntry validationEntry : footballPlayerValidationEntryList) {
            if (validationEntry.getInvalidFieldName().equals(fieldName) &&
                    validationEntry.getInvalidFieldReason().equals(validationErrorMessage)) {
                containsData = true;
                break;
            }
        }
        assertTrue(containsData);
    }

    private void setupValidFootballPlayer() {
        footballPlayer = new FootballPlayer();
        footballPlayer.setFirstName("Joe");
        footballPlayer.setLastName("Blogs");
        footballPlayer.setNickname("JB");
        footballPlayer.setEmailAddress("joe.blogs@hotmail.co.uk");
        footballPlayer.setPhoneNumber("078321651351");
    }
}
