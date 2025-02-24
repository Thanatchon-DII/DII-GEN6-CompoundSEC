package main.java.com.example.addcards_setpermissions;

import main.java.com.example.addcards_setpermissions.levelCard.CardStrategy;
import main.java.com.example.eventlog.AuditlogSingleton;
import java.util.Scanner;

public class CardControl {
    private CardStrategy strategy;
    public String cardId_Name;
    public String accessLevel;
    public boolean isActive;

    public CardControl(CardStrategy strategy) {
        System.out.print("Enter Card Holder Name: ");
        Scanner name = new Scanner(System.in);
        this.cardId_Name = name.nextLine();
        setCardLevel(strategy);

    }

    public void setCardLevel(CardStrategy strategy) { // เปลี่ยนระดับการเข้าถึง
        this.strategy = strategy;
        AuditlogSingleton.logRecord("Method : setCardLevel (Change Clearance Holder) | " + this.cardId_Name + // savelogตามหลักควรจะเก็บค่าเก่า
                " | Last : " + this.accessLevel + " Clearance Holder State:" +
                this.isActive + " to New  : " + this.accessLevel +
                " Clearance Holder State:" + (this.isActive ? "Granted" : "Revoked"));
        this.accessLevel = strategy.setAccessLevel();
        this.isActive = strategy.setisActive();
        System.out.println("!! New " + this.accessLevel + // แสดงผลว่าสำเร็จ
                " Clearance Holder | Name: " + this.cardId_Name + " | State:"
                + (this.isActive ? "Granted" : "Revoked"));
    }

    public void revokeCard() {
        this.isActive = false;
        AuditlogSingleton.logRecord("Method : revokeCard (Revoke Clearance Holder) | " + this.cardId_Name + // save log
                " | " + this.accessLevel + " Clearance Holder State:Revoked");
        System.out.println("!! Revoke " + this.accessLevel + // แสดงผลว่าสำเร็จ
                " Clearance Holder | Name: " + this.cardId_Name + " | State:Revoked");
    }
}
