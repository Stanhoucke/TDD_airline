package vehicle;

public enum PlaneType {
    A380(10, 300.00),
    A350(6, 200.00),
    A320(4, 150.00),
    PRIVATE_JET(2, 75.00);

    private final int passengerCapacity;
    private final double weight;

    PlaneType(int passengerCapacity, double weight) {
        this.passengerCapacity = passengerCapacity;
        this.weight = weight;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public double getWeight() {
        return this.weight;
    }
}
