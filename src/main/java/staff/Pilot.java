package staff;

public class Pilot extends AirCrew{

    private String licenceNumber;
    public Pilot(String name, RankType rankType, String licenceNumber){
        super(name, rankType);
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceNumber(){
        return this.licenceNumber;
    }

    public String flyPlane(){
        return "This is your captain speaking, prepare for take off.";
    }
}
