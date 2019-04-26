package com.softwire.training.parking;

import java.util.*;

public class MultiStorey {

    private ArrayList<Floor> multiStoreyFloors;

    public MultiStorey(Collection<Floor> floors) {
       this.multiStoreyFloors = new ArrayList<>(floors);
    }

    public MultiStorey(Floor... floors) {
        this(Arrays.asList(floors));
    }


    public Collection<Floor> getFloors() {
        return multiStoreyFloors;
    }

    public ParkingSpace getNearestSpaceForVehicle(Vehicle vehicle) {
        multiStoreyFloors.sort(Comparator.comparing(Floor::getFloorNumber));
        for (Floor floor :multiStoreyFloors) {
            if (floor.getNearestFreeSpaceForVehicle(vehicle) != null) {
                return floor.getNearestFreeSpaceForVehicle(vehicle);
            }
        }
        return null;
    }

    public ParkingSpace getSpaceContainingVehicleWithRegistration(String registration) {
        for (Floor floor :multiStoreyFloors) {
            for (ParkingSpace parkingSpace : floor.getParkingSpaces()){
                if (parkingSpace.isOccupied() && parkingSpace.getParkedVehicle().getRegistration().equals(registration)) {
                    return parkingSpace;
                }
            }
        }
        return null;
    }
}
