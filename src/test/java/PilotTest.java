import org.junit.Before;
import org.junit.Test;
import staff.Pilot;
import staff.RankType;

import static org.junit.Assert.assertEquals;

public class PilotTest {
    Pilot pilot1;

    @Before
    public void before(){
        pilot1 = new Pilot("Sully", RankType.CAPTAIN, "JA-5678");
    }

    @Test
    public void hasName(){
        assertEquals("Sully", pilot1.getName());
    }

    @Test
    public void hasRankType(){
        assertEquals(RankType.CAPTAIN, pilot1.getRankType());
    }

    @Test
    public void hasLicenceNumber(){
        assertEquals("JA-5678", pilot1.getLicenceNumber());
    }

    @Test
    public void canFlyPlane(){
        assertEquals("This is your captain speaking, prepare for take off.", pilot1.flyPlane());
    }
}
