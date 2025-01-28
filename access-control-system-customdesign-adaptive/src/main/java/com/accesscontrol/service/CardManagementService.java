package main.java.com.accesscontrol.service;

import java.util.HashMap;
import java.util.Map;

import main.java.com.accesscontrol.model.Card; // คนละ Directory

public class CardManagementService {
    private static Map<String, Card> cards = new HashMap<>();

    public static void addCard(String cardId, String accessLevel) {
        cards.put(cardId, new Card(cardId, accessLevel));
    }

    public static void modifyCard(String cardId, String newAccessLevel) {
        if (cards.containsKey(cardId)) {
            cards.put(cardId, new Card(cardId, newAccessLevel));
        }
    }

    public static void revokeCard(String cardId) {
        if (cards.containsKey(cardId)) {
            cards.get(cardId).deactivate();
        }
    }

    public static void showAllCards() {
        cards.values().forEach(System.out::println);
    }
}
