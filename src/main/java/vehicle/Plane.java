package vehicle;

public class Plane {
    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType(){
        return this.planeType;
    }

    public int getPassengerCapacity(){
        return this.planeType.getPassengerCapacity();
    }

    public double getWeight(){
        return this.planeType.getWeight();
    }

}
