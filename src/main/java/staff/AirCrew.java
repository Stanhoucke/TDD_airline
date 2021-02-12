package staff;

public abstract class AirCrew {
    private String name;
    private RankType rankType;

    public AirCrew(String name, RankType rankType) {
        this.name = name;
        this.rankType = rankType;
    }

    public String getName() {
        return this.name;
    }

    public RankType getRankType() {
        return this.rankType;
    }
}
