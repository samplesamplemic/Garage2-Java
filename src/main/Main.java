import com.mic.garage.vehicle.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("---Program start---");
        Scanner scanner = new Scanner(System.in);
        int maxSiteGarage = 6;
        Vehicle garage[] = new Vehicle[maxSiteGarage];

        //General vehicle
        int id = 0;
        String typeVehicle;
        String brand;
        int year;
        int carEngineCapacity;

        //Particular
        //van
        CargoCapacity cargoCapacity;
        //car
        Doors doors;
        Fuel fuel;
        //moto
        Times times;

        doors = Doors.createDoors(5);
        garage[1] = new Car(doors, Fuel.DIESEL, 1, "Ford", 2006, 1300);
        garage[2] = new Car(doors, Fuel.DIESEL, 2, "Ford", 2006, 1300);
        garage[3] = new Car(doors, Fuel.DIESEL, 3, "Ford", 2006, 1300);
        garage[0] = new Car(doors, Fuel.DIESEL, 0, "Ford", 2006, 1300);


        while (true) {

            //find void park if there aren't, print and break
            if (!(Arrays.asList(garage).contains(null))) {
                System.out.println("Max parking site reached");
                break;
            }

            System.out.println("\nGarage\n");
            System.out.print("Available commands: search || parking || recover || exit\n");
            System.out.print("Command: ");

            String command = scanner.next();

            if (command.equals("parking")) {
                System.out.println("brand: ");
                scanner.skip("[\r\n]"); // cause nextLine() will print also year;
                brand = scanner.nextLine();
                System.out.println("year: ");
                year = scanner.nextInt();
                System.out.println("Engine capacity: ");
                carEngineCapacity = scanner.nextInt();
                System.out.println("type of vehicle: car, moto, van?");
                typeVehicle = scanner.next();
                // search the sub-class
                switch (typeVehicle) {
                    case "car" -> {
                        try {
                            System.out.println("Doors (from 3 to 5): ");
                            doors = Doors.createDoors(scanner.nextInt());
                            System.out.println("Fuel (Diesel or Petrol): ");
                            fuel = Fuel.valueOf(scanner.next().toUpperCase().trim());
                            Car car = new Car(doors, fuel, id, brand, year, carEngineCapacity);
                            searchVoidPark(car, garage);
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
                            searchVoidPark(moto, garage);
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
                            searchVoidPark(van, garage);
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

            if (command.equals("recover")) {
                System.out.println("To recover your vehicle insert your parking ID: ");
                int idFromUser = scanner.nextInt();
                for (int i = 0; i < garage.length; i++) {

                    if (garage[i] == null) {
                        System.out.println("Id not found.");
                        continue;
                    }

                    if (garage[i].getId() == idFromUser) {
                        System.out.println("Do you want recover this vehicle: " + garage[idFromUser].toString() + "\ny/n");
                        String recoverAnswer = scanner.next();

                        if (recoverAnswer.equals("y")) {
                            garage[idFromUser] = null;
                            System.out.println("Recover successful");
                            break;
                        }
                        break;
                    }
                }
            }

            if (command.equals("search")) {
                Main.printGarage(garage);
            }

            if (command.equals("exit")) {
                break;
            }
        }

        //Print array
        printGarage(garage);
    }

    //iterates in sup-class array, find a void park, locate; then stop loop;
    public static void searchVoidPark(Vehicle obj, Vehicle[] garage) {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == null) {
                garage[i] = obj;
                obj.setId(i);
                break;
            }
        }
    }

    public static void printGarage(Vehicle[] garage) {
        for (int i = 0; i < garage.length; i++) {
            // if (garage[i] != null) {

            System.out.println(garage[i]);
            // }
        }
    }
}
