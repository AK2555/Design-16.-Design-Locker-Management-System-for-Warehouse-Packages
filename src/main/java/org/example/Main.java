package org.example;

import org.example.entities.Locker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Example 1
        LockerManager sys = new LockerManager();
        sys.addSlot("M"); // creates "M1"
        sys.addSlot("L");  // creates "L1"

        String m1 = sys.findSlot("M");     // returns a free medium locker ( id "M1")
        sys.occupySlot(m1);        // true
        sys.freeSlot(m1);          // true
    }
}