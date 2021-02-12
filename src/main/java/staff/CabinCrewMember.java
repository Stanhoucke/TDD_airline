package staff;

public class CabinCrewMember extends AirCrew{
    public CabinCrewMember(String name, RankType rankType) {
        super(name, rankType);
    }

    public String cabinAnnouncement(){
        return "Exits are located here, here, and here.";
    }
}
