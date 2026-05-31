package manager;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import models.Vehicle;

public class VehicleManager {
    private Scanner scanner;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleManager(ArrayList<Vehicle> vehicles, Scanner scanner) {
        this.vehicles = vehicles;
        this.scanner = scanner;
    }

    private Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getID() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public void rentVeh() {
        int id;
        try {
            System.out.print("\nEnter vehicle id to rent: ");
            id = scanner.nextInt();
            scanner.nextLine();
            Vehicle vehicle = findVehicleById(id);
            if (vehicle == null) {
                System.out.println("Vehicle not found");
                return;
            }
            vehicle.rentVehicle();
        } catch (InputMismatchException e) {
            System.out.println("Invalid id type!");
            scanner.nextLine();
            return;
        }
    }

    public void returnVeh() {
        int id;
        try {
            System.out.print("\nEnter vehicle id to return: ");
            id = scanner.nextInt();
            scanner.nextLine();
            Vehicle vehicle = findVehicleById(id);
            if (vehicle == null) {
                System.out.println("Vehicle not found recheck your vehicle code!");
                return;
            }
            if (!vehicle.isAvailable()) {
                vehicle.returnVehicle();
            } else {
                System.out.println("Vehicle already returned!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid id type!");
            scanner.nextLine();
            return;
        }

    }

    public void changeRent() {
        int id;
        double rent;
        try {
            System.out.print("\nEnter vehicle id: ");
            id = scanner.nextInt();
            scanner.nextLine();
            Vehicle vehicle = findVehicleById(id);
            if (vehicle == null) {
                System.out.println("Vehicle not found recheck your vehicle code!");
                return;
            }
            System.out.print("Enter new rent: ");
            rent = scanner.nextDouble();
            scanner.nextLine();
            vehicle.setRate(rent);
            System.out.printf("%s rent modified to: %.2f\n", vehicle.getName(), rent);
        } catch (InputMismatchException e) {
            System.out.println("Invalid id type!");
            scanner.nextLine();
            return;
        }
    }

}
