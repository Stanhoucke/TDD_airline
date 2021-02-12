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

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight1;
    Pilot pilot1;
    Plane plane1;

    @Before
    public void before(){
        pilot1 = new Pilot("Sully", RankType.CAPTAIN, "JA-5678");
        plane1 = new Plane(PlaneType.A380);

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
}
