package models;

public class Car extends Vehicle {
    int seats;

    // Car Constructor overloaded
    public Car(String name, double rentPerDay, int vehID, int seats) {
        super(name, rentPerDay, vehID, true);
        this.seats = seats;
    }

    public Car(String name, double rentPerDay, int vehID, int seats, boolean availabilityStatus) {
        super(name, rentPerDay, vehID, availabilityStatus);
        this.seats = seats;
    }

    // Overridden methods
    @Override
    public void displayInfo() {
        String rented = (isAvailable()) ? "no" : "yes";
        System.out.printf("\nName: %s %d-seater\nVehicleID: %d\nRent: %.2f\nRented: %s\n",
                getName(),
                seats,
                getID(),
                getRate(),
                rented);
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public String toString() {
        return "NAME: " + getName() + " ID:" + getID() + " RATE:" + getRate() + " SEATS:" + seats;
    }

}
