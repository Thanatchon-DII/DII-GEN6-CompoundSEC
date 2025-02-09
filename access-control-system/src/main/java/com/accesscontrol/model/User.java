package main.java.com.accesscontrol.model;

import main.java.com.accesscontrol.controller.Accessible;

public class User extends Card implements Accessible {

    public User(String cardId, String accessLevel) {
        super(cardId, accessLevel);
        this.accessLevel = accessLevel;
    }

    public boolean hasAccess(String requiredLevel) {
        return this.isActive && this.accessLevel.equalsIgnoreCase(requiredLevel);
    }

    public boolean validateAccess(String requiredLevel) {
        return this.isActive && this.accessLevel.equalsIgnoreCase(requiredLevel);
    }
}
