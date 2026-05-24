import java.time.LocalDate;

public class PracticeStat extends BaseStat {
    private String drillName;

    public PracticeStat(StatType stat, double value, LocalDate date, SeasonType season, String drillName) {
        super(stat, value, date, season);
        this.drillName = drillName;
    }

    public String getDrillName() {
        return drillName;
    }

    public void setDrillName(String drillName) {
        if (drillName == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.drillName = drillName;
    }

    @Override
    public StatSource getSource() {
        return StatSource.PRACTICE;
    }
}
