import airline.Airport;
import airline.Flight;
import airline.Passenger;
import org.junit.Before;
import org.junit.Test;
import staff.CabinCrewMember;
import staff.Pilot;
import staff.RankType;
import vehicle.Plane;
import vehicle.PlaneType;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {

    Flight flight1;
    Pilot pilot1;
    Plane plane1;
    CabinCrewMember cabinCrewMember1;
    CabinCrewMember cabinCrewMember2;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before(){
        pilot1 = new Pilot("Sully", RankType.CAPTAIN, "JA-5678");
        plane1 = new Plane(PlaneType.A380);
        cabinCrewMember1 = new CabinCrewMember("Lorraine Sullenberger", RankType.PURSER);
        cabinCrewMember2 = new CabinCrewMember("Tess Sosa", RankType.FLIGHT_ATTENDANT);
        passenger1 = new Passenger("Neville Flynn", 2);
        passenger2 = new Passenger("Big Leroy", 1);

        flight1 = new Flight(pilot1, plane1, "JAA6902", Airport.EDI, Airport.GVA, "2021-02-15 08:00");
    }

    // Attribute tests
    @Test
    public void hasPilot() {
        assertEquals(pilot1, flight1.getPilot());
    }

    @Test
    public void hasCrew(){
        assertEquals(new ArrayList<CabinCrewMember>(), flight1.getCrew());
    }

    @Test
    public void hasPassengers(){
        assertEquals(new ArrayList<Passenger>(), flight1.getPassengers());
    }

    @Test
    public void hasPlane(){
        assertEquals(plane1, flight1.getPlane());
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("JAA6902", flight1.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals(Airport.EDI, flight1.getDestination());
    }

    @Test
    public void hasDepartureAirport(){
        assertEquals(Airport.GVA, flight1.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals("2021-02-15 08:00", flight1.getDepartureTime());
    }

    // ArrayList tests
    @Test
    public void canCountCrew(){
        assertEquals(0, flight1.countCrew());
    }

    @Test
    public void canCountPassengers(){
        assertEquals(0, flight1.countPassengers());
    }

    @Test
    public void canAddCrewMember(){
        flight1.addCrew(cabinCrewMember1);
        assertEquals(1, flight1.countCrew());
    }

    @Test
    public void canRemoveCrewMember(){
        flight1.addCrew(cabinCrewMember1);
        flight1.addCrew(cabinCrewMember2);
        flight1.removeCrew(cabinCrewMember2);
        assertEquals(cabinCrewMember1, flight1.getCrew().get(0));
    }

    @Test
    public void canAddPassenger(){
        flight1.addPassenger(passenger1);
        assertEquals(1, flight1.countPassengers());
    }

    @Test
    public void canRemovePassenger(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.removePassenger(passenger1);
        assertEquals(1, flight1.countPassengers());
    }

    @Test
    public void canRemoveAllPassengers(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.removeAllPassengers();
        assertEquals(0, flight1.countPassengers());
    }

    @Test
    public void canCheckSeatAvailability__ReturnsTrue(){
        assertTrue(flight1.hasAvailableSeat());
    }

    @Test
    public void canCheckSeatAvailability__ReturnsFalse(){
        for (int i = 0; i < 10; i++){
            flight1.addPassenger(passenger1);
        }
        assertFalse(flight1.hasAvailableSeat());
    }

    @Test
    public void canCountAvailableSeats(){
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.removePassenger(passenger1);
        flight1.addPassenger(passenger1);
        assertEquals(8, flight1.countAvailableSeats());
    }

    @Test
    public void canBookPassenger(){
        flight1.bookPassenger(passenger1);
        assertEquals(1, flight1.countPassengers());
    }

    @Test
    public void doesNotBookPassengerOnFullFlight(){
        for (int i = 0; i < 12; i++){
            flight1.bookPassenger(passenger1);
        }
        assertEquals(10, flight1.countPassengers());
    }
}
