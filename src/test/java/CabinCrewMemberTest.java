import org.junit.Before;
import org.junit.Test;
import staff.CabinCrewMember;
import staff.RankType;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {
    CabinCrewMember cabinCrewMember1;

    @Before
    public void before(){
        cabinCrewMember1 = new CabinCrewMember("Lorraine Sullenberger", RankType.PURSER);
    }

    @Test
    public void hasName(){
        assertEquals("Lorraine Sullenberger", cabinCrewMember1.getName());
    }

    @Test
    public void hasRankType(){
        assertEquals(RankType.PURSER, cabinCrewMember1.getRankType());
    }

    @Test
    public void canCabinAnnouncement(){
        assertEquals("Exits are located here, here, and here.", cabinCrewMember1.cabinAnnouncement());
    }

}
