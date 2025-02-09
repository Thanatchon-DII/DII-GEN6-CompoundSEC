package main.java.com.accesscontrol.controller;

public interface Accessible {
    boolean hasAccess(String requiredLevel);
}
