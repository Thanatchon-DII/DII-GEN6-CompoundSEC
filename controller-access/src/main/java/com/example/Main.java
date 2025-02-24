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
        while (true) {
            System.out.println("\nAccess Control System");
            System.out.println("1. Create New Card");
            System.out.println("2. Revoke Access");
            System.out.println("3. Change Access Level");
            System.out.println("4. View Card Information");
            System.out.println("5. Show Audit Logs");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
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
                    viewCard();
                    break;
                case 5:
                    AuditlogSingleton.showLogs();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
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
                break;
            case 2:
                card = new CardControl(new LevelSecret());
                break;
            case 3:
                card = new CardControl(new LevelTopSecret());
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
                break;
            case 2:
                card.setCardLevel(new LevelSecret());
                break;
            case 3:
                card.setCardLevel(new LevelTopSecret());
                break;
            default:
                System.out.println("Invalid level selected.");
        }
    }

    private static void viewCard() {
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
        AccessController.checkAccess(card.accessLevel, (card.isActive ? "Granted" : "Revoked"));
    }
}
