package app;

import models.*;
import manager.VehicleManager;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Random gen = new Random();

    // polymorphic Array
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        // Array instantiation
        vehicles.add(new Car("Ford Fiesta", 1500.90, Math.abs(gen.nextInt(100, 1000)), 4, true));
        vehicles.add(new Car("Nexon EV", 900.15, Math.abs(gen.nextInt(100, 1000)), 4, true));
        vehicles.add(new Car("Bolero", 2500.70, Math.abs(gen.nextInt(100, 1000)), 5, false));
        vehicles.add(new Bike("Bullet 500", 2000, Math.abs(gen.nextInt(100, 1000)), 5, true));
        vehicles.add(new Bike("Honda CB350", 1500, Math.abs(gen.nextInt(100, 1000)), 6, false));
        vehicles.add(new Bike("Himalayan 411", 35000, Math.abs(gen.nextInt(100, 1000)), 6, true));
        vehicles.add(new Truck("Ashok Leyland", 5000, Math.abs(gen.nextInt(100, 1000)), 1500, true));

        VehicleManager manager = new VehicleManager(vehicles, scanner);
        boolean isRunning = true;
        int choice;
        try {
            do {
                System.out.println("\n[1] Show Vehicle");
                System.out.println("[2] Add Vehicle");
                System.out.println("[3] Rent Vehicle");
                System.out.println("[4] Return Vehicle");
                System.out.println("[5] Change Rent");
                System.out.println("[6] Exit");

                try {
                    System.out.print("Enter Your Choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> showVeh();
                        case 2 -> addVeh();
                        case 3 -> manager.rentVeh();
                        case 4 -> manager.returnVeh();
                        case 5 -> manager.changeRent();
                        case 6 -> isRunning = false;
                        case 00 -> magicDebug();
                        default -> {
                            System.out.println("Invalid Choice!");
                            continue;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Choice!");
                    scanner.nextLine();
                    continue;
                }

                if (!isRunning) {
                    System.out.println("Exiting....");
                    break;
                }

            } while (isRunning);
        } catch (NoSuchElementException e) {
            System.out.println("\nCtrl + C Detected! \nExiting now...");
        } finally {
            scanner.close();
        }
    }

    static void showVeh() {
        System.out.println("\n-------------------");
        System.out.println("Vehicles");
        System.out.println("-------------------");
        // Runtime Polymorphism
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
        System.out.println("\n[+]Available for Renting: " + Vehicle.availableVehCount);
    }

    static void addVeh() {
        VehicleType type;
        System.out.println("\nChoose your type");
        System.out.println("[1] Bike");
        System.out.println("[2] Car");
        System.out.println("[3] Truck");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> type = VehicleType.BIKE;
            case 2 -> type = VehicleType.CAR;
            case 3 -> type = VehicleType.TRUCK;
            default -> {
                System.out.println("Invalid vehicle type!");
                return;
            }
        }

        instantiateVeh(type);
    }

    static void instantiateVeh(VehicleType type) {
        int gears, seats, load;
        System.out.print("\nEnter Vehicle name: ");
        String name = scanner.nextLine();
        System.out.print("Rent per day: ");
        double rent = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Vehicle ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        switch (type) {
            case BIKE -> {
                System.out.print("Enter gears: ");
                gears = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Bike(name, rent, id, gears));
                System.out.println("Bike added successfully.");
            }
            case CAR -> {
                System.out.print("Enter seats: ");
                seats = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Car(name, rent, id, seats));
                System.out.println("Car added successfully.");
            }
            case TRUCK -> {
                System.out.print("Enter max load:");
                load = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Truck(name, rent, id, load));
                System.out.println("Truck added successfully.");
            }
        }
    }

    static void magicDebug() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

}
