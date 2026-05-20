import java.util.*;
import java.time.LocalDate;

public class Player {
    public static Player allTimeTopScorer = null;

    private String name;
    private Position position;
    private int capNumber;
    private ArrayList<BaseStat> stats;
    private boolean isLefty;
    private double pb50m;
    private double pb100m;

    public Player(String name, Position position, int capNumber, ArrayList<BaseStat> stats, boolean isLefty,
            double pb50m, double pb100m) {
        this.name = name;
        this.position = position;
        this.capNumber = capNumber;
        this.stats = stats;
        this.isLefty = isLefty;
        this.pb50m = pb50m;
        this.pb100m = pb100m;
    }

    public Player(String name, int capNumber, Position position) {
        this.name = name;
        this.position = position;
        this.capNumber = capNumber;
        this.stats = new ArrayList<BaseStat>();
        this.isLefty = false;
        pb50m = Double.MAX_VALUE;
        pb100m = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCapNumber() {
        return capNumber;
    }

    public void setCapNumber(int capNumber) {
        this.capNumber = capNumber;
    }

    public ArrayList<BaseStat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<BaseStat> stats) {
        this.stats = stats;
    }

    public boolean isLefty() {
        return isLefty;
    }

    public void setLefty(boolean isLefty) {
        this.isLefty = isLefty;
    }

    public double getPb50m() {
        return pb50m;
    }

    public void updatePb50m(double pb50m) {
        if (pb50m < this.pb50m) {
            this.pb50m = pb50m;
        }
    }

    public double getPb100m() {
        return pb100m;
    }

    public void updatePb100m(double pb100m) {
        if (pb100m < this.pb100m) {
            this.pb100m = pb100m;
        }
    }

    public void addStat(BaseStat stat) {
        stats.add(stat);
        // add MVP thing
    }

    public double getTotal(StatType type, SeasonType season) {
        double sum = 0;
        for (BaseStat stat : stats) {
            if (stat.getStat() == type) {
                sum += stat.getValue();
            }
        }
        return sum;
    }

    public double getTotalForTournament(StatType type, Tournament tournament) {
        double sum = 0;
        for (BaseStat stat : stats) {
            if (stat.)
        }
    }

    public double getTotalCombined(StatType type) {
        double sum = 0;
        for (BaseStat stat : stats) {
            if (stat.getStat() == type) {
                sum += stat.getValue();
            }
        }
        return sum;
    }

}
