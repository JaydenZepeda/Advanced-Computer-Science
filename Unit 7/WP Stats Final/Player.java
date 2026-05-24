import java.util.*;
import java.time.LocalDate;

public class Player {
    public static Player allTimeTopScorer = null;

    private String name;
    private Position position;
    private ArrayList<BaseStat> stats;
    private boolean isLefty;
    private double pb50m;
    private double pb100m;

    public Player(String name, Position position, ArrayList<BaseStat> stats, boolean isLefty,
            double pb50m, double pb100m) {
        if (name == null || position == null || stats == null || pb100m == 0.0 || pb50m == 0.0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.name = name;
        this.position = position;
        this.stats = stats;
        this.isLefty = isLefty;
        this.pb50m = pb50m;
        this.pb100m = pb100m;
    }

    public Player(String name, Position position) {
        if (name == null || position == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.name = name;
        this.position = position;
        this.stats = new ArrayList<BaseStat>();
        this.isLefty = false;
        pb50m = Double.MAX_VALUE;
        pb100m = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.position = position;
    }

    public ArrayList<BaseStat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<BaseStat> stats) {
        if (stats == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        for (BaseStat stat : stats) {
            if (stat == null) {
                throw new IllegalArgumentException("Invalid Input");
            }
        }
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
        if (stat == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        stats.add(stat);
        if (stat.getStat() == StatType.SHOTS_SCORED) {
            if (allTimeTopScorer == null || this.getTotalCombined(StatType.SHOTS_SCORED,
                    StatSource.GAME) > allTimeTopScorer.getTotalCombined(StatType.SHOTS_SCORED, StatSource.GAME)) {
                allTimeTopScorer = this;
            }
        }
    }

    public double getTotalGoals() {
        return getTotalCombined(StatType.SHOTS_SCORED, StatSource.GAME);
    }

    public double getTotal(StatType type, SeasonType season, int year, StatSource source) {
        if (type == null || source == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        double sum = 0;
        for (BaseStat stat : stats) {
            if (stat.getStat() == type
                    && (season == null || stat.getSeason() == season)
                    && (source == StatSource.BOTH || stat.getSource() == source)
                    && (year == 0 || stat.getDate().getYear() == year)) {
                sum += stat.getValue();
            }
        }
        return sum;
    }

    public double getTotalForTournament(StatType type, Tournament tournament, int year) {
        if (type == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        double sum = 0;
        for (BaseStat stat : stats) {
            if (stat.getSource() == StatSource.GAME) {
                GameStat gameStat = (GameStat) stat;
                if (gameStat.getTournament() == tournament && stat.getStat() == type) {
                    if (year == 0 || stat.getDate().getYear() == year) {
                        sum += stat.getValue();
                    }
                }
            }
        }
        return sum;
    }

    public double getTotalCombined(StatType type, StatSource source) {
        return getTotal(type, null, 0, source);
    }

    public double getTotalInRange(StatType type, LocalDate start, LocalDate end, SeasonType season, StatSource source) {
        if (type == null || start == null || end == null || source == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        double sum = 0;
        for (BaseStat stat : stats) {
            if (stat.getStat() == type && (season == null || stat.getSeason() == season) &&
                    !stat.getDate().isBefore(start) && !stat.getDate().isAfter(end) &&
                    (source == StatSource.BOTH || stat.getSource() == source)) {
                sum += stat.getValue();
            }
        }
        return sum;
    }

    public double getAverageInRange(StatType type, LocalDate start, LocalDate end, SeasonType season,
            StatSource source) {
        if (type == null || start == null || end == null || source == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        double totalValue = 0;
        double divisor = 0;
        for (BaseStat stat : stats) {
            if (stat.getStat() == type && (season == null || stat.getSeason() == season) &&
                    !stat.getDate().isBefore(start) && !stat.getDate().isAfter(end) &&
                    (source == StatSource.BOTH || stat.getSource() == source)) {
                totalValue += stat.getValue();
            }
        }
        if (source == StatSource.GAME || source == StatSource.BOTH) {
            divisor += getTotalInRange(StatType.GAMES_PLAYED, start, end, season, StatSource.GAME);
        }
        if (source == StatSource.PRACTICE || source == StatSource.BOTH) {
            divisor += getTotalInRange(StatType.PRACTICES, start, end, season, StatSource.PRACTICE);
        }
        if (divisor == 0) {
            return 0;
        }
        return totalValue / divisor;
    }

    public String formatStatName(StatType type) {
        if (type == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        String name = type.name().replace('_', ' ').toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public int getStatWeight(StatType type) {
        if (type == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (type == StatType.GAMES_PLAYED || type == StatType.PRACTICES || type == StatType.METERS_SWAM) {
            return 0;
        }
        if (type == StatType.BAD_PASSES || type == StatType.TURN_OVER ||
                type == StatType.EXCULSIONS || type == StatType.PENALTY_FOULS ||
                type == StatType.PENALTY_CONCEDED || type == StatType.GOALS_AGAINST ||
                type == StatType.CENTER_GOALS_AGAINST) {
            return -1;
        }
        return 1;
    }

    public double getImpactScore() {
        double totalImpact = 0;
        for (StatType type : StatType.values()) {
            int weight = getStatWeight(type);
            if (weight != 0) {
                totalImpact += (getTotalCombined(type, StatSource.BOTH) * weight);
            }
        }
        return totalImpact;
    }

    public void printStatSheet() {
        System.out.println(
                "\n====================================================================================================");
        System.out.println("FULL STAT SHEET: " + name);
        System.out.println("PB 50m: " + (pb50m == Double.MAX_VALUE ? "N/A" : pb50m + "s") + " | PB 100m: "
                + (pb100m == Double.MAX_VALUE ? "N/A" : pb100m + "s"));
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
                "Stat Category", "Comb Tot", "Comb Avg", "Club Tot", "Club Avg", "HS Tot", "HS Avg");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");

        for (StatType type : StatType.values()) {
            double cTot = getTotalCombined(type, StatSource.BOTH);
            double cAvg = getAverageInRange(type, LocalDate.MIN, LocalDate.MAX, null, StatSource.BOTH);

            double clubTot = getTotal(type, SeasonType.CLUB, 0, StatSource.BOTH);
            double clubAvg = getAverageInRange(type, LocalDate.MIN, LocalDate.MAX, SeasonType.CLUB, StatSource.BOTH);

            double hsTot = getTotal(type, SeasonType.HIGH_SCHOOL, 0, StatSource.BOTH);
            double hsAvg = getAverageInRange(type, LocalDate.MIN, LocalDate.MAX, SeasonType.HIGH_SCHOOL,
                    StatSource.BOTH);

            if (cTot != 0) {
                System.out.printf("%-25s | %-10.1f | %-10.2f | %-10.1f | %-10.2f | %-10.1f | %-10.2f\n",
                        formatStatName(type), cTot, cAvg, clubTot, clubAvg, hsTot, hsAvg);
            }
        }
    }
}