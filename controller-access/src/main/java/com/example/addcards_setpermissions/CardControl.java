package main.java.com.example.addcards_setpermissions;

import main.java.com.example.addcards_setpermissions.levelCard.CardStrategy;
import main.java.com.example.eventlog.AuditlogSingleton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CardControl {
    private CardStrategy strategy;
    public String cardId_Name;
    public String accessLevel;
    public boolean isActive;
    public String pin; // จะต้องมาผ่านตัว Encrypt

    private static String pattern = "MMddyyyy";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); // ใช้ในการเปลี่ยนรูปแบบ วัน
    String pins = simpleDateFormat.format(new Date());

    public CardControl(CardStrategy strategy) {
        System.out.print("Enter Card Holder Name: ");
        Scanner name = new Scanner(System.in);
        this.cardId_Name = name.nextLine();
        setCardLevel(strategy);
    }

    public void setCardLevel(CardStrategy strategy) { // เปลี่ยนระดับการเข้าถึง
        pins += this.cardId_Name;
        this.strategy = strategy;
        this.accessLevel = strategy.setAccessLevel();
        this.isActive = strategy.setisActive();
        this.pin = this.accessLevel.equalsIgnoreCase("Confidential")
                ? String.format("%sCT%s", pins.substring(0, 4), pins.substring(4))
                : this.accessLevel.equalsIgnoreCase("Secret")
                        ? String.format("%sST%s", pins.substring(0, 4), pins.substring(4))
                        : String.format("%sTS%s", pins.substring(0, 4), pins.substring(4));
    }

    public void revokeCard() {
        this.isActive = false;
        AuditlogSingleton
                .logRecord("< Revoke > " + cardId_Name + " | (L) " + accessLevel + " | (S) "
                        + (isActive ? "Granted" : "Revoked"));
        System.out.println("!! Revoke Card");
    }
}
