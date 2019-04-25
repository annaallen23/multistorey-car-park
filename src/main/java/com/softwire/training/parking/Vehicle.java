package com.softwire.training.parking;

public class Vehicle {

    private String registration;
    private double height;
    private double width;
    private Type type;

    public Vehicle(Type type, String registration, double height, double width) {
        this.registration = registration;
        this.height = height;
        this.width = width;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getRegistration() {
        return registration;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public enum Type {
        CAR,
        MOTORCYCLE,
        VAN,
    }
}
