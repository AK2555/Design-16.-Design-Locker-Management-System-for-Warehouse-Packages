package org.example.factory;

import org.example.entities.Locker;
import org.example.state.AvailableLockerState;

import java.util.Set;

public class LockerFactory {
    private static final  Set<String> validSizes=Set.of("S","M","L","XL","XXL");

    public static Locker createLocker(String size,int id){
        if(!validSizes.contains(size)){
            return null;
        }
        Locker locker=new Locker(size+id,size,new AvailableLockerState());
        return locker;
    }

    public static boolean isValidSize(String size){
        return validSizes.contains(size);
    }
}
