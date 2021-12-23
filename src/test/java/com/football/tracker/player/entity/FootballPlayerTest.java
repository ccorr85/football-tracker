package com.football.tracker.player.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballPlayerTest {

    private FootballPlayer footballPlayer;
    private final String firstName = "Joe";
    private final String lastName = "Blogs";
    private final String nickname = "JB";
    private final String emailAddress = "joe.blogs@hotmail.co.uk";
    private final String phoneNumber = "07593018506";

    @BeforeEach
    public void setup() {
        footballPlayer = new FootballPlayer();
        setupFootballPlayer();
    }

    @Test
    public void testFirstName() {
        assertEquals(firstName, footballPlayer.getFirstName());
    }

    @Test
    public void testLastName() {
        assertEquals(lastName, footballPlayer.getLastName());
    }

    @Test
    public void testNickname() {
        assertEquals(nickname, footballPlayer.getNickname());
    }

    @Test
    public void testEmailAddress() {
        assertEquals(emailAddress, footballPlayer.getEmailAddress());
    }

    @Test
    public void testPhoneNumber() {
        assertEquals(phoneNumber, footballPlayer.getPhoneNumber());
    }

    private void setupFootballPlayer() {
        footballPlayer.setFirstName(firstName);
        footballPlayer.setLastName(lastName);
        footballPlayer.setNickname(nickname);
        footballPlayer.setEmailAddress(emailAddress);
        footballPlayer.setPhoneNumber(phoneNumber);
    }
}
