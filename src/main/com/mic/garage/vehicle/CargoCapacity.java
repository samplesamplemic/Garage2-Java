package com.mic.garage.vehicle;

public class CargoCapacity {

    private int cargoCapacity;

    private CargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public static CargoCapacity createCargoCapacity(int cargoCapacity) {
        if (cargoCapacity >= 0) {
            return new CargoCapacity(cargoCapacity);
        } else {
            throw new RuntimeException("The value of cargo Capacity must be positive.");
        }
    }

    public String toString(){
        return String.valueOf(cargoCapacity);
    }

}
