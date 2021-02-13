import airline.Airport;
import airline.Flight;
import airline.FlightManager;
import airline.Passenger;
import org.junit.Before;
import org.junit.Test;
import staff.CabinCrewMember;
import staff.Pilot;
import staff.RankType;
import vehicle.Plane;
import vehicle.PlaneType;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightManagerTest {
    Flight flight1;
    Pilot pilot1;
    Plane plane1;
    CabinCrewMember cabinCrewMember1;
    CabinCrewMember cabinCrewMember2;
    Passenger passenger1;
    Passenger passenger2;
    FlightManager flightManager;

    @Before
    public void before(){
        pilot1 = new Pilot("Sully", RankType.CAPTAIN, "JA-5678");
        plane1 = new Plane(PlaneType.A380);
        cabinCrewMember1 = new CabinCrewMember("Lorraine Sullenberger", RankType.PURSER);
        cabinCrewMember2 = new CabinCrewMember("Tess Sosa", RankType.FLIGHT_ATTENDANT);
        passenger1 = new Passenger("Neville Flynn", 0);
        passenger2 = new Passenger("Big Leroy", 1);

        flight1 = new Flight(pilot1, plane1, "JAA6902", Airport.EDI, Airport.GVA, LocalDateTime.of(2021, 2, 15, 8, 30));

        flightManager = new FlightManager(flight1);
    }

    @Test
    public void hasFlight(){
        assertEquals(flight1, flightManager.getFlight());
    }

    @Test
    public void canGetPassengerBaggageWeightAllowance(){
        assertEquals(15.00, flightManager.getPassengerBaggageWeightAllowance(), 0.0);
    }

    @Test
    public void canGetTotalPassengerBaggageWeight(){
        flightManager.getFlight().bookPassenger(passenger1);
        flightManager.getFlight().bookPassenger(passenger2);
        flightManager.getFlight().bookPassenger(passenger2);
        assertEquals(30.00, flightManager.getTotalPassengerBaggageWeight(), 0.0);
    }

    @Test
    public void canGetRemainingBaggageWeight(){
        flightManager.getFlight().bookPassenger(passenger1);
        flightManager.getFlight().bookPassenger(passenger2);
        flightManager.getFlight().bookPassenger(passenger2);
        assertEquals(120.00, flightManager.getRemainingBaggageWeight(), 0.0);
    }

    @Test
    public void canBookPassengerToFlight(){
        flightManager.bookPassengerToFlight(passenger1);
        assertEquals(1, flightManager.getFlight().countPassengers());
    }

    @Test
    public void doesNotBookPassengerOnFullFlight(){
        for (int i = 0; i < 12; i++){
            flightManager.bookPassengerToFlight(passenger1);
        }
        assertEquals(10, flightManager.getFlight().countPassengers());
    }

    @Test
    public void canAssignPassengerSeatNumber(){
        flightManager.bookPassengerToFlight(passenger1);
        flightManager.assignPassengerSeatNumber(passenger1);
        assertNotEquals(0, flightManager.getFlight().findPassenger(passenger1).getSeatNumber());
    }

    @Test
    public void passengerAssignedFlightWhenBooked(){
        flightManager.bookPassengerToFlight(passenger2);
        flightManager.bookPassengerToFlight(passenger1);
        Flight passengerFlight = flightManager.getFlight().findPassenger(passenger1).getFlight();
        assertEquals(flight1, passengerFlight);
    }


}
