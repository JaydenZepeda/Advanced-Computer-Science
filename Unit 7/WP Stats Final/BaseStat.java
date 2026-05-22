import java.time.LocalDate;

public abstract class BaseStat {
    private StatType stat;
    private double value;
    private LocalDate date;
    private SeasonType season;

    public BaseStat(StatType stat, double value, LocalDate date, SeasonType season) {
        this.stat = stat;
        this.value = value;
        this.date = date;
        this.season = season;
    }

    public StatType getStat() {
        return stat;
    }

    public void setStat(StatType stat) {
        if (stat == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.stat = stat;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value < 0.0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SeasonType getSeason() {
        return season;
    }

    public void setSeason(SeasonType season) {
        this.season = season;
    }

    public abstract StatSource getSource();

}
