package org.example.entities;

import org.example.state.LockerState;

public class Locker {
    private final String id;
    private final String size;
    private LockerState state;

    public Locker(String id,String size,LockerState state){
        this.id=id;
        this.size=size;
        this.state=state;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public LockerState getState() {
        return state;
    }

    public void setState(LockerState state) {
        this.state = state;
    }

    public void free(){
        state.free(this);
    }
    public void occupy(){
        state.occupy(this);
    }
}
