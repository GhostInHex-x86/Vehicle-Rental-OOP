package models;

public class Bike extends Vehicle {
    int gears;

    // Bike Constructors overloaded
    public Bike(String name, double rentPerDay, int vehID, int gears) {
        super(name, rentPerDay, vehID, true);
        this.gears = gears;
    }

    public Bike(String name, double rentPerDay, int vehID, int gears, boolean availabilityStatus) {
        super(name, rentPerDay, vehID, availabilityStatus);
        this.gears = gears;
    }

    // Overridden methods
    @Override
    public void displayInfo() {
        String rented = (isAvailable()) ? "no" : "yes";
        System.out.printf("\nName: %s %d-speed gearbox\nVehicleID: %d\nRent: %.2f\nRented: %s\n",
                getName(),
                gears,
                getID(),
                getRate(),
                rented);
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }

    @Override
    public String toString() {
        return "NAME: " + getName() + " ID:" + getID() + " RATE:" + getRate() + " GEARS:" + gears;
    }
}
