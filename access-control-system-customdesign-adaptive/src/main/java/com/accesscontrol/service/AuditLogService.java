package main.java.com.accesscontrol.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AuditLogService {
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
