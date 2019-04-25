package com.softwire.training.parking;

public class ParkingSpace {

    private int id;
    private double maxHeight;
    private double maxWidth;
    private Vehicle.Type typeRestriction;
    private Vehicle parkedVehicle;

    public ParkingSpace(int id, double maxHeight, double maxWidth) {
        this.id = id;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public ParkingSpace(int id, double maxHeight, double maxWidth, Vehicle.Type typeRestriction) {
        this.id = id;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.typeRestriction = typeRestriction;
    }

    public int getId() {
        return id;
    }

    public boolean isVehicleAllowed(Vehicle vehicle) {
        if ((vehicle.getHeight() > this.maxHeight) || (vehicle.getWidth() > this.maxWidth) || (typeRestriction != null) && (vehicle.getType() != typeRestriction)) {
            return false;
        }
        return true;
    }

    public void parkVehicle(Vehicle vehicle) throws IllegalArgumentException, IllegalStateException {
        if (isOccupied()) {
            throw new IllegalStateException("Space is already occupied");
        }
        if (!isVehicleAllowed(vehicle)) {
            throw new IllegalArgumentException("Vehicle is not allowed in this space");
        }
        parkedVehicle = vehicle;
    }

    public void vacate() {
        if (isOccupied()) parkedVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isOccupied() {
        if (parkedVehicle == null) {
            return false;
        }
        return true;
    }
}
