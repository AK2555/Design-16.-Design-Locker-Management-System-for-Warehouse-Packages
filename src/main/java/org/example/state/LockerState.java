package org.example.state;

import org.example.entities.Locker;

public interface LockerState {
    void free(Locker locker);
    void occupy(Locker locker);
}
