package com.mic.garage;

import com.mic.garage.vehicle.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTest {

    private Vehicle v;

    @BeforeEach
    void setUp() {
        v = new Vehicle(1, "Ford", 2006, 1300);
    }

    @Test
    public void testClassVehicle() {
        assertTrue("ID: 1 - Brand: Ford - Year: 2006 - Engine capacity: 1300".equalsIgnoreCase(v.toString()));
    }

    @Test
    public void testClassCar() {
        Doors doors = Doors.createDoors(4);
        Car car = new Car(doors, Fuel.DIESEL, v.getId(), v.getBrand(), v.getYear(), v.getCarEngineCapacity());
        assertTrue("ID: 1 - Brand: Ford - Year: 2006 - Engine capacity: 1300 - doors: 4 - fuel: diesel".equalsIgnoreCase(car.toString()));
    }

    @Test
    public void testClassMoto() {
        Times times = Times.createTimes(2);
        Moto moto = new Moto(times, v.getId(), v.getBrand(), v.getYear(), v.getCarEngineCapacity());
        assertTrue("ID: 1 - Brand: Ford - Year: 2006 - Engine capacity: 1300 - times: 2".equalsIgnoreCase(moto.toString()));
    }

    @Test
    public void testClassVan() {
        CargoCapacity cargoCapacity = CargoCapacity.createCargoCapacity(200);
        Van van = new Van(cargoCapacity, v.getId(), v.getBrand(), v.getYear(), v.getCarEngineCapacity());
        assertTrue("ID: 1 - Brand: Ford - Year: 2006 - Engine capacity: 1300 - cargo capacity: 200kg".equalsIgnoreCase(van.toString()));
    }

    @Test
    public void testThrowExceptionDoors() {
        Exception exception = assertThrows(RuntimeException.class, () -> Doors.createDoors(2));
        assertEquals("The value of doors must be between 3 and 5, extremes included.", exception.getMessage());
    }

    @Test
    public void testThrowExceptionTimes() {
        Exception exception = assertThrows(RuntimeException.class, () -> Times.createTimes(1));
        assertEquals("The value of times must be 2 or 4.", exception.getMessage());
    }

    @Test
    public void testThrowExceptionCargoCapacity() {
        Exception exception = assertThrows(RuntimeException.class, () -> CargoCapacity.createCargoCapacity(-100));
        assertEquals("The value of cargo Capacity must be positive.", exception.getMessage());
    }

}
