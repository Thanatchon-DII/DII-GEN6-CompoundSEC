package main.java.com.example.eventlog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AuditlogSingleton {
    private static AuditlogSingleton instance;
    private static String pattern = "MM/dd/yyyy";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); // ใช้ในการเปลี่ยนรูปแบบ วัน

    private static List<String> logs = new ArrayList<>();

    private AuditlogSingleton() {
        if (instance != null) {
            throw new RuntimeException("Cannot create more than one instance of log");
        }
    }

    public static AuditlogSingleton getInstance() {
        if (instance == null) {
            instance = new AuditlogSingleton();
        }
        return instance;
    }

    public static void logRecord(String log) {
        logs.add(simpleDateFormat.format(new Date()) + " | " + log);
    }

    public static void showLogs() { // คำสั่งโชว์ AuditLog ทั้งหมดในตอนนี้
        logs.forEach(System.out::println);
    }
}
