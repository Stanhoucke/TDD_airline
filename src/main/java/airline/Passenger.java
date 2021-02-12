package airline;

public class Passenger {
    private String name;
    private int numberOfBags;
    private Flight flight;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.flight = null;
    }

    public String getName() {
        return this.name;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getNumberOfBags() {
        return this.numberOfBags;
    }
}
