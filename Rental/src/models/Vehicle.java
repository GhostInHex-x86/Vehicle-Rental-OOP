package models;

import interfaces.Rentable;

public abstract class Vehicle implements Rentable {
    // Encapsulated data
    private String name;
    public static int availableVehCount = 0;
    private double rentPerDay;
    private int vehID;
    private boolean status;

    // Vehicle Constructor
    protected Vehicle(String name, double rentPerDay, int vehID, boolean status) {
        this.name = name;
        this.rentPerDay = rentPerDay;
        this.vehID = vehID;
        this.status = status;
        availableVehCount++;
    }

    // Abstract methods
    public abstract void displayInfo();

    public abstract String getVehicleType();

    public void rentVehicle() {
        if (status) {
            status = false;
            System.out.println(getVehicleType() + " Rented successfully");
            availableVehCount--;
        } else {
            System.out.println(getVehicleType() + " already rented");
        }
    }

    public void returnVehicle() {
        status = true;
        System.out.println(getVehicleType() + " returned successfully");
        availableVehCount++;
    }

    // Setters and Getters
    public void setRate(double rate) {
        rentPerDay = rate;
    }

    public boolean isAvailable() {
        return status;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rentPerDay;
    }

    public int getID() {
        return vehID;
    }
}
