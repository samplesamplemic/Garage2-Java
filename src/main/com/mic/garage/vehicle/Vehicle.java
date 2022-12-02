package com.mic.garage.vehicle;

public class Vehicle {

    private int id, year, carEngineCapacity;
    private String brand;

    public Vehicle(int id, String brand, int year, int carEngineCapacity) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.carEngineCapacity = carEngineCapacity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCarEngineCapacity() {
        return this.carEngineCapacity;
    }

    public void setCarEngineCapacity(int carEngineCapacity) {
        this.carEngineCapacity = carEngineCapacity;
    }

    public String toString() {
        return "ID: ".concat(Integer.toString(this.id)).concat(" - Brand: " + this.brand).concat(" - Year: " + this.year).concat(" - Engine capacity: " + this.carEngineCapacity);
    }
}
