package main.java.com.accesscontrol.model;

import java.util.*;

public class Card {
    private String cardId;
    private String accessLevel;
    private boolean isActive;

    public Card(String cardId, String accessLevel) {
        this.cardId = cardId;
        this.accessLevel = accessLevel;
        this.isActive = true;
    }

    public String getCardId() {
        return cardId;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        return "Card ID: " + cardId + ", Access Level: " + accessLevel + ", Active: " + isActive;
    }

}