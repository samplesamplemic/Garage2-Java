package com.mic.garage.vehicle;

public class Moto extends Vehicle {
    private Times times;

    public Moto(Times times, int id, String brand, int year, int carEngineCapacity) {
        super(id, brand, year, carEngineCapacity);
        this.times = times;
    }

    public Times getTimes() {
        return this.times;
    }

    @Override
    public String toString() {
        return super.toString().concat(" - times: " + this.times);
    }
}