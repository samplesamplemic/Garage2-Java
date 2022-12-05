package com.mic.garage.vehicle;

import java.util.Arrays;
import java.util.Scanner;

public final class Garage {
    //the right way is this:
    //final private Scanner scanner;
    //final private int maxSiteGarage;
    //final private Vehicle[] garage;
    //constructor

    //these three declaration below break the fifth SOLID principle: Dependency Inversion
    final private int maxSiteGarage = 6;
    final private Vehicle[] garage = new Vehicle[maxSiteGarage];
    final private Scanner scanner = new Scanner(System.in);
    //General vehicle

    private int id = 0;
    private String typeVehicle;
    private String brand;
    private int year;
    private int carEngineCapacity;

    //Particular
    //van
    private CargoCapacity cargoCapacity;
    //car
    private Doors doors;
    private Fuel fuel;
    //moto
    private Times times;

    //will be automatically generated a default/nullary constructor:
    //class Garage(){ super();}

    public void createGarage() {
        while (true) {

            //find void park if them there aren't, instance recover method;
            if (!(Arrays.asList(garage).contains(null))) {
                System.out.println("Max parking site reached");
                recoverVehicle();
            }

            System.out.println("\nGarage\n");
            System.out.print("Available commands: search || parking || recover || exit\n");
            System.out.print("Command: ");
            String command = scanner.next();


            if (command.equalsIgnoreCase("parking")) {
                System.out.println("brand: ");
                scanner.skip("[\r\n]"); // cause nextLine() will print also year;
                brand = scanner.nextLine();
                System.out.println("year: ");
                year = scanner.nextInt();
                System.out.println("Engine capacity: ");
                carEngineCapacity = scanner.nextInt();
                System.out.println("type of vehicle: car, moto, van?");
                typeVehicle = scanner.next();
                // search the subclass
                switch (typeVehicle) {
                    case "car" -> {
                        try {
                            System.out.println("Doors (from 3 to 5): ");
                            doors = Doors.createDoors(scanner.nextInt());
                            System.out.println("Fuel (Diesel or Petrol): ");
                            fuel = Fuel.valueOf(scanner.next().toUpperCase().trim());
                            Car car = new Car(doors, fuel, id, brand, year, carEngineCapacity);
                            searchFirstVoidPark(car, garage);
                            System.out.println(car);
                        } catch (Exception e) {
                            System.out.println(e);
                            continue;
                        }
                    }
                    case "moto" -> {
                        try {
                            System.out.println("times(2 or 4): ");
                            times = Times.createTimes(scanner.nextInt());
                            Moto moto = new Moto(times, id, brand, year, carEngineCapacity);
                            searchFirstVoidPark(moto, garage);
                            System.out.println(moto);
                        } catch (Exception e) {
                            System.out.println(e);
                            continue;
                        }
                    }
                    case "van" -> {
                        try {
                            System.out.println("cargo capacity(kg): ");
                            cargoCapacity = CargoCapacity.createCargoCapacity(scanner.nextInt());
                            Van van = new Van(cargoCapacity, id, brand, year, carEngineCapacity);
                            searchFirstVoidPark(van, garage);
                            System.out.println(van.toString());
                        } catch (Exception e) {
                            System.out.println(e);
                            continue;
                        }
                    }
                    default -> {
                        System.out.println("Vehicle not valid.");
                        continue;
                    }
                }

            }

            if (command.equalsIgnoreCase("recover")) {
                recoverVehicle();
            }

            if (command.equalsIgnoreCase("search")) {
                printGarage(garage);
            }

            if (command.equalsIgnoreCase("exit")) {
                break;
            }
        }

        //Print array
        printGarage(garage);

    }

    public void recoverVehicle() {
        System.out.println("To recover your vehicle insert your parking ID: ");
        int idFromUser = scanner.nextInt();
        for (int i = 0; i < garage.length; i++) {

            if (garage[i] == null) {
                System.out.println("Id not found.");
                break;
            }

            if (garage[i].getId() == idFromUser) {
                System.out.println("Do you want recover this vehicle: " + garage[idFromUser].toString() + "\ny/n");
                String recoverAnswer = scanner.next();

                if (recoverAnswer.equalsIgnoreCase("y")) {
                    garage[idFromUser] = null;
                    System.out.println("Recover successful");
                    break;
                }
                break;
            }
        }
    }

    //iterates in sup-class array, find a void park, locate; then stop loop;
    public void searchFirstVoidPark(Vehicle obj, Vehicle[] garage) {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == null) {
                garage[i] = obj;
                obj.setId(i);
                break;
            }
        }
    }

    public void printGarage(Vehicle[] garage) {
        for (Vehicle vehicle : garage) {
            System.out.println(vehicle);
        }
    }

}
