package models;

public class Truck extends Vehicle {
    int load;

    // Truck Constructor overloaded
    public Truck(String name, double rentPerDay, int vehID, int load) {
        super(name, rentPerDay, vehID, true);
        this.load = load;
    }

    public Truck(String name, double rentPerDay, int vehID, int load, boolean availabilityStatus) {
        super(name, rentPerDay, vehID, availabilityStatus);
        this.load = load;
    }

    // Overridden methods
    @Override
    public void displayInfo() {
        String rented = (isAvailable()) ? "no" : "yes";
        System.out.printf("\nName: %s\nMaxLoad: %d Kg\nVehicleID: %d\nRent: %.2f\nRented %s\n",
                getName(),
                load,
                getID(),
                getRate(),
                rented);
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }

    @Override
    public String toString() {
        return "NAME: " + getName() + " ID:" + getID() + " RATE:" + getRate() + " LOAD:" + load + "Kg";
    }
}
