import java.util.*;

class Card {
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

class AuditLog {
    private static List<String> logs = new ArrayList<>();

    public static void logAccess(String cardId, boolean success) {
        String logEntry = "Card ID: " + cardId + " - Access " + (success ? "GRANTED" : "DENIED") + " at " + new Date();
        logs.add(logEntry);
        System.out.println(logEntry);
    }

    public static void showLogs() {
        logs.forEach(System.out::println);
    }
}

class AccessControl {
    public static boolean checkAccess(Card card, String requiredLevel) {
        boolean accessGranted = card.isActive() && card.getAccessLevel().equalsIgnoreCase(requiredLevel);
        AuditLog.logAccess(card.getCardId(), accessGranted);
        return accessGranted;
    }
}

class CardManager {
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

public class Main {
    public static void main(String[] args) {
        CardManager.addCard("12345", "LOW");
        CardManager.addCard("67890", "HIGH");

        Card card1 = new Card("12345", "LOW");
        Card card2 = new Card("67890", "HIGH");

        AccessControl.checkAccess(card1, "HIGH");
        AccessControl.checkAccess(card2, "HIGH");

        AuditLog.showLogs();
        CardManager.showAllCards();
    }
}
