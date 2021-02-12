import org.junit.Before;
import org.junit.Test;
import vehicle.Plane;
import vehicle.PlaneType;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane1;

    @Before
    public void before(){
        plane1 = new Plane(PlaneType.A380);
    }

    @Test
    public void hasPlaneType(){
        assertEquals(PlaneType.A380, plane1.getPlaneType());
    }

    @Test
    public void PlaneTypeHasPassengerCapacity(){
        assertEquals(10, plane1.getPassengerCapacity());
    }

    @Test
    public void PlaneTypeHasWeight(){
        assertEquals(300.00, plane1.getWeight(), 0.0);
    }
}
