package main.java.com.example.accessAuthentication;

import java.util.logging.Level;

import main.java.com.example.accessAuthentication.informationlevel.ComponentData;
import main.java.com.example.accessAuthentication.informationlevel.LevelConfidential;
import main.java.com.example.accessAuthentication.informationlevel.LevelSecret;
import main.java.com.example.accessAuthentication.informationlevel.LevelTopSecret;

public class AccessController {

    public static void checkAccess(String level, String status, String pin) { // pin จะต้องมาผ่านตัว Decrypt

        if (level.equalsIgnoreCase("Confidential") && status.equals("Granted")
                && pin.substring(4, 6).equals("CT")) {
            ComponentData levelConfidential = new LevelConfidential();
            System.out.println(levelConfidential.informationData());
        } else if (level.equalsIgnoreCase("Secret") && status.equals("Granted")
                && pin.substring(4, 6).equals("ST")) {
            ComponentData levelConfidential = new LevelConfidential();
            ComponentData levelSecret = new LevelSecret(levelConfidential);
            System.out.println(levelSecret.informationData());
        } else if (level.equalsIgnoreCase("Top Secret") && status.equals("Granted")
                && pin.substring(4, 6).equals("TS")) {
            ComponentData levelConfidential = new LevelConfidential();
            ComponentData levelSecret = new LevelSecret(levelConfidential);
            ComponentData levelTopSecret = new LevelTopSecret(levelSecret);
            System.out.println(levelTopSecret.informationData());
        }
    }
}
