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

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PassengerTest {

    Passenger passenger1;
    Pilot pilot1;
    Plane plane1;
    Flight flight1;

    @Before
    public void before(){
        pilot1 = new Pilot("Sully", RankType.CAPTAIN, "JA-5678");
        plane1 = new Plane(PlaneType.A380);
        passenger1 = new Passenger("Neville Flynn", 0);

        flight1 = new Flight(pilot1, plane1, "JAA6902", Airport.EDI, Airport.GVA, LocalDateTime.of(2021, 2, 15, 8, 30));
    }

    @Test
    public void hasName(){
        assertEquals("Neville Flynn", passenger1.getName());
    }

    @Test
    public void hasNumberOfBags(){
        assertEquals(0, passenger1.getNumberOfBags());
    }

    @Test
    public void passengerStartsWithNoFlight(){
        assertNull(passenger1.getFlight());
    }
}
