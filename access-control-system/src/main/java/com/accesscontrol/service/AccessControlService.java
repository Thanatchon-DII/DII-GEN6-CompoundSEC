package main.java.com.accesscontrol.service;

// import main.java.com.accesscontrol.model.Card;
import main.java.com.accesscontrol.model.User; // คนละ Directory

public class AccessControlService {
    public static boolean checkAccess(User card1, String requiredLevel) {
        boolean accessGranted = card1.isActive() && card1.getAccessLevel().equalsIgnoreCase(requiredLevel);
        AuditLogService.logAccess(card1.getCardId(), accessGranted);
        return accessGranted;
    }
}
