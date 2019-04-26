package com.softwire.training.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Floor {

    private int floorNumber;
    private List<ParkingSpace> parkingSpaces = new ArrayList<>();
    private int capacity;
    private int numberOfFreeSpaces;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Collection<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.add(parkingSpace);
    }

    public int getCapacity() {
        return parkingSpaces.size();
    }

    public int getNumberOfFreeSpaces() {
        int numberOfFreeSpaces = 0;
        for (ParkingSpace parkingSpace : parkingSpaces){
            if (!parkingSpace.isOccupied()){
                numberOfFreeSpaces ++;
            }

        }
        return numberOfFreeSpaces;
    }
}
