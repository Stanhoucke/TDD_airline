package airline;

import staff.CabinCrewMember;
import staff.Pilot;
import vehicle.Plane;

import java.util.ArrayList;

public class Flight {
    private Pilot pilot;
    private ArrayList<CabinCrewMember> crew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport destination;
    private Airport departureAirport;
    private String departureTime;

    public Flight(Pilot pilot, Plane plane, String flightNumber, Airport destination, Airport departureAirport, String departureTime) {
        this.pilot = pilot;
        this.crew = new ArrayList<CabinCrewMember>();
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    // Getters
    public Pilot getPilot() {
        return this.pilot;
    }

    public ArrayList<CabinCrewMember> getCrew() {
        return this.crew;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public Airport getDestination() {
        return this.destination;
    }

    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }
}
