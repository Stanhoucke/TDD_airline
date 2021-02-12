import airline.Passenger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger1;

    @Before
    public void before(){
        passenger1 = new Passenger("Neville Flynn", 2);
    }

    @Test
    public void hasName(){
        assertEquals("Neville Flynn", passenger1.getName());
    }

    @Test
    public void hasNumberOfBags(){
        assertEquals(2, passenger1.getNumberOfBags());
    }
}
