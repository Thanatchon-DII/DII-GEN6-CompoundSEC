package main.java.com.example;

import main.java.com.example.addcards_setpermissions.CardControl;
import main.java.com.example.addcards_setpermissions.levelCard.LevelConfidential;
import main.java.com.example.addcards_setpermissions.levelCard.LevelSecret;
import main.java.com.example.addcards_setpermissions.levelCard.LevelTopSecret;
import main.java.com.example.eventlog.AuditlogSingleton;
import main.java.com.example.accessAuthentication.AccessController;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, CardControl> cardDatabase = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loopRun();
    }

    private static void loopRun() {
        while (true) {
            System.out.println("\nAccess Control System");
            System.out.println("1. Create New Card");
            System.out.println("2. Revoke Access");
            System.out.println("3. Change Access Level");
            System.out.println("4. Check access level");
            System.out.println("5. Show Audit Logs");
            System.out.println("6. Show All Cards");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();
            try {
                switch (Integer.parseInt(choice)) {
                    case 1:
                        createCard();
                        break;
                    case 2:
                        revokeCard();
                        break;
                    case 3:
                        changeAccessLevel();
                        break;
                    case 4:
                        checkaccesslevel();
                        break;
                    case 5:
                        AuditlogSingleton.showLogs();
                        break;
                    case 6:
                        showAllCard();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void showAllCard() {
        System.out.println("All Cards:\n");
        if (cardDatabase.isEmpty()) {
            System.out.println("No cards available.");
            return;
        }
        for (Map.Entry<String, CardControl> entry : cardDatabase.entrySet()) {
            CardControl card = entry.getValue();
            System.out.println("Name: " + card.cardId_Name);
            System.out.println("Access Level: " + card.accessLevel);
            System.out.println("Status: " + (card.isActive ? "Granted" : "Revoked"));
            System.out.println("Pin: " + card.pin);
            System.out.println("-----------------------------");
        }
    }

    private static void createCard() {

        System.out.println("Select Access Level:");
        System.out.println("1. Confidential");
        System.out.println("2. Secret");
        System.out.println("3. Top Secret");

        int level = scanner.nextInt();
        scanner.nextLine();

        CardControl card;
        switch (level) {
            case 1:
                card = new CardControl(new LevelConfidential());
                AuditlogSingleton
                        .logRecord("< Create > " + card.cardId_Name + " | (L) " + card.accessLevel + " | (S) "
                                + (card.isActive ? "Granted" : "Revoked"));
                break;
            case 2:
                card = new CardControl(new LevelSecret());
                AuditlogSingleton
                        .logRecord("< Create > " + card.cardId_Name + " | (L) " + card.accessLevel + " | (S) "
                                + (card.isActive ? "Granted" : "Revoked"));
                break;
            case 3:
                card = new CardControl(new LevelTopSecret());
                AuditlogSingleton
                        .logRecord("< Create > " + card.cardId_Name + " | (L) " + card.accessLevel + " | (S) "
                                + (card.isActive ? "Granted" : "Revoked"));
                break;
            default:
                System.out.println("Invalid level selected.");
                return;
        }

        cardDatabase.put(card.cardId_Name, card);
        System.out.println("Card created successfully for " + card.cardId_Name);
    }

    private static void revokeCard() {
        System.out.print("Enter Card Holder Name to Revoke: ");
        String name = scanner.nextLine();

        CardControl card = cardDatabase.get(name);
        if (card != null) {
            card.revokeCard();
            System.out.println("Card revoke successfully for " + card.cardId_Name);
        } else {
            System.out.println("Card not found.");
        }
    }

    private static void changeAccessLevel() {
        System.out.print("Enter Card Holder Name to Change Access Level: ");
        String name = scanner.nextLine();

        CardControl card = cardDatabase.get(name);
        if (card == null) {
            System.out.println("Card not found.");
            return;
        } else if (!card.isActive) {
            System.out.println("Status : Revoked (Yes / No (y/n))");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
            } else {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("Select New Access Level:");
        System.out.println("1. Confidential");
        System.out.println("2. Secret");
        System.out.println("3. Top Secret");

        int level = scanner.nextInt();
        scanner.nextLine();

        switch (level) {
            case 1:
                card.setCardLevel(new LevelConfidential());
                AuditlogSingleton
                        .logRecord("< Change > " + card.cardId_Name + " | (L) " + card.accessLevel + " | (S) "
                                + (card.isActive ? "Granted" : "Revoked"));
                break;
            case 2:
                card.setCardLevel(new LevelSecret());
                AuditlogSingleton
                        .logRecord("< Change > " + card.cardId_Name + " | (L) " + card.accessLevel + " | (S) "
                                + (card.isActive ? "Granted" : "Revoked"));
                break;
            case 3:
                card.setCardLevel(new LevelTopSecret());
                AuditlogSingleton
                        .logRecord("< Change > " + card.cardId_Name + " | (L) " + card.accessLevel + " | (S) "
                                + (card.isActive ? "Granted" : "Revoked"));
                break;
            default:
                System.out.println("Invalid level selected.");
        }
    }

    private static void checkaccesslevel() {
        System.out.print("Enter Card Holder Name: ");
        String name = scanner.nextLine();

        CardControl card = cardDatabase.get(name);
        if (card == null) {
            System.out.println("Card not found.");
            return;
        }

        System.out.println("Card Information:");
        System.out.println("Name: " + card.cardId_Name);
        System.out.println("Access Level: " + card.accessLevel);
        System.out.println("Status: " + (card.isActive ? "Granted" : "Revoked"));

        System.out.println("Accessing classified information:");
        AccessController.checkAccess(card.accessLevel, (card.isActive ? "Granted" : "Revoked"), card.pin);
    }
}
