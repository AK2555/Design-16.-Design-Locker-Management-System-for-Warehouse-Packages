package org.example.state;

import org.example.entities.Locker;

public class OccupiedLockerState implements LockerState{
    @Override
    public void free(Locker locker) {
        locker.setState(new AvailableLockerState());
    }

    @Override
    public void occupy(Locker locker) {

    }
}
