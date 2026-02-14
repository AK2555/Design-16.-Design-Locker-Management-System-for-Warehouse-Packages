package org.example.state;

import org.example.entities.Locker;

public class AvailableLockerState implements LockerState{
    @Override
    public void free(Locker locker) {

    }

    @Override
    public void occupy(Locker locker) {
          locker.setState(new OccupiedLockerState());
    }
}
