package airline;

public class FlightManager {
    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public double getPassengerBaggageWeightAllowance() {
        double planeWeight = this.flight.getPlane().getWeight();
        int planeCapacity = this.flight.getPlane().getPassengerCapacity();
        double baggageWeightAllowance = planeWeight / 2;
        return baggageWeightAllowance / planeCapacity;
    }

    public double getTotalPassengerBaggageWeight() {
        return this.getPassengerBaggageWeightAllowance() * this.flight.countPassengerBags();
    }

    public double getRemainingBaggageWeight() {
        double baggageWeightAllowance = this.flight.getPlane().getWeight() / 2;
        return baggageWeightAllowance - this.getTotalPassengerBaggageWeight();
    }

    public void bookPassengerToFlight(Passenger passenger) {
        this.getFlight().bookPassenger(passenger);
    }
}
