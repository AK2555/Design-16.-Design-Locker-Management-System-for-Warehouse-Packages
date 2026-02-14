package org.example;

import org.example.entities.Locker;
import org.example.factory.LockerFactory;
import org.example.state.AvailableLockerState;
import org.example.state.OccupiedLockerState;

import java.util.*;

public class LockerManager {
    private Map<String, TreeMap<String, Locker>> lockers;
    private Map<String,Locker> lockerMap;

    public LockerManager() {
        this.lockers=new HashMap<>();
        lockerMap=new HashMap<>();
    }

    public void addSlot(String size) {
        if(!LockerFactory.isValidSize(size)){
            return;
        }
        TreeMap<String,Locker> sameSizeLocker=lockers.get(size);
        int len=0;
        if(sameSizeLocker!=null){
            len=sameSizeLocker.size();
        }
        len++;
        Locker locker= LockerFactory.createLocker(size,len);
      //  Locker locker=new Locker(size+""+len, size,true);
        lockerMap.put(locker.getId(),locker);
        if(sameSizeLocker==null){
            lockers.put(size,new TreeMap<>());
        }
        lockers.get(size).put(locker.getId(),locker);
    }

    public String findSlot(String size) {
        TreeMap<String,Locker> sameSizeLocker=lockers.get(size);
        if(sameSizeLocker==null){
            return "";
        }

        for(Map.Entry<String,Locker> me: sameSizeLocker.entrySet()){
            String key=me.getKey();
            Locker val=me.getValue();
            if(val.getState().getClass() == AvailableLockerState.class){
                return key;
            }
        }
        return "";
    }

    public boolean occupySlot(String lockerId) {
        Locker locker=lockerMap.get(lockerId);
        if(locker==null || locker.getState().getClass() == OccupiedLockerState.class){
            return false;
        }
       locker.occupy();

        return true;
    }

    public boolean freeSlot(String lockerId) {
        Locker locker=lockerMap.get(lockerId);
        if(locker==null || locker.getState().getClass() == AvailableLockerState.class){
            return false;
        }
        locker.free();

        return true;
    }
}
