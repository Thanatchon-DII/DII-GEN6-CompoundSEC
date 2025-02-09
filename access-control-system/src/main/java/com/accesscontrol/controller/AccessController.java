package main.java.com.accesscontrol.controller;

import main.java.com.accesscontrol.model.User;

public class AccessController {
    public static void processAccess(User card, String requiredLevel) {
        if (card.validateAccess(requiredLevel)) {
            System.out.println("Access GRANTED for Card ID: " + card.getCardId());
        } else {
            System.out.println("Access DENIED for Card ID: " + card.getCardId());
        }
    }
}