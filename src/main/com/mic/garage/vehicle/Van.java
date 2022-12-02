package com.mic.garage.vehicle;

public class Van extends Vehicle {
    private CargoCapacity cargoCapacity;

    public Van(CargoCapacity cargoCapacity, int id, String brand, int year, int carEngineCapacity) {
        super(id, brand, year, carEngineCapacity);
        this.cargoCapacity = cargoCapacity;
    }

    public CargoCapacity getCargoCapacity() {
        return this.cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString().concat(" - cargo capacity: " + this.cargoCapacity + "kg");
    }

}