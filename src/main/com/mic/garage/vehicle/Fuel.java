package com.mic.garage.vehicle;

public enum Fuel {
    DIESEL,
    PETROL;

    @Override
    public String toString(){
        return name().toLowerCase();
    }
}
