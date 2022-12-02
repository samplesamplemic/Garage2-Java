package com.mic.garage.vehicle;

public class Car extends Vehicle {
    private Doors doors;
    private Fuel fuel;

    public Car(Doors doors, Fuel fuel, int id, String brand, int year, int carEngineCapacity) {
        super(id, brand, year, carEngineCapacity);
        this.doors = doors;
        this.fuel = fuel;
    }

    public Doors getDoors() {
        return this.doors;
    }

//    commented cause value object principle: immutability;
//    public void setDoors(Doors doors) {
//        this.doors = doors;
//    }
//    public void setFuel(Fuel fuel) {this.fuel =fuel;}

    public Fuel getFuel() {
        return this.fuel;
    }

    @Override
    public String toString() {
        return super.toString().concat(" - doors: " + this.doors).concat(" - fuel: " + this.fuel);
    }

}
