package main.java.com.accesscontrol.model;

import java.util.*;

abstract class Card {
    protected String cardId;
    protected String accessLevel;
    protected boolean isActive;

    public Card(String cardId, String accessLevel) {
        this.cardId = cardId;
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

    public abstract boolean validateAccess(String requiredLevel);

}