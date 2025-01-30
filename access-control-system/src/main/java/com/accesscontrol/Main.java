package main.java.com.accesscontrol;

import main.java.com.accesscontrol.model.Card; // คนละ Directory
import main.java.com.accesscontrol.service.AccessControlService; // คนละ Directory
import main.java.com.accesscontrol.service.AuditLogService; // คนละ Directory
import main.java.com.accesscontrol.service.CardManagementService; // คนละ Directory

public class Main {
    public static void main(String[] args) {
        CardManagementService.addCard("12345", "LOW");
        CardManagementService.addCard("67890", "HIGH");

        Card card1 = new Card("12345", "LOW");
        Card card2 = new Card("67890", "HIGH");

        AccessControlService.checkAccess(card1, "HIGH");
        AccessControlService.checkAccess(card2, "HIGH");

        AuditLogService.showLogs();
        CardManagementService.showAllCards();
    }
}
