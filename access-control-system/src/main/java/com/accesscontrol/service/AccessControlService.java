package main.java.com.accesscontrol.service;

import main.java.com.accesscontrol.model.Card; // คนละ Directory

public class AccessControlService {
    public static boolean checkAccess(Card card, String requiredLevel) {
        boolean accessGranted = card.isActive() && card.getAccessLevel().equalsIgnoreCase(requiredLevel);
        AuditLogService.logAccess(card.getCardId(), accessGranted);
        return accessGranted;
    }
}
