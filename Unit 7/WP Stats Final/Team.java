import java.time.LocalDate;
import java.util.*;

public class Team {
    private ArrayList<Player> players;
    private String teamName;
    private int teamYear;
    private SeasonType season;
    private int wins = 0;
    private int losses = 0;
    private ArrayList<Player> starters;

    public Team(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        teamName = name;
        players = new ArrayList<Player>(30);
        teamYear = LocalDate.now().getYear();
        this.season = SeasonType.CLUB;
    }

    public Team(String teamName, int maxCap, SeasonType season, int year) {
        if (teamName == null || maxCap == 0 || season == null || year == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.teamName = teamName;
        this.season = season;
        this.teamYear = year;
        this.players = new ArrayList<Player>();
        for (int i = 0; i <= maxCap; i++) {
            players.add(null);
        }
    }

    public Team(String name, ArrayList<Player> players, int year, SeasonType season) {
        if (name == null || players == null || year == 0 || season == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        teamName = name;
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if (teamName == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.teamName = teamName;
    }

    public void addPlayer(Player player, int capNum) {
        if (capNum < players.size()) {
            players.set(capNum, player);
        }
    }

    public int getTeamYear() {
        return teamYear;
    }

    public void setTeamYear(int teamYear) {
        if (teamYear == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.teamYear = teamYear;
    }

    public SeasonType getSeason() {
        return season;
    }

    public void setSeason(SeasonType season) {
        if (season == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.season = season;
    }

    public void setStarters(ArrayList<Player> starters) {
        if (starters.size() == 6) {
            boolean full = true;
            for (Player player : starters) {
                if (player == null) {
                    full = false;
                }
            }
            if (full) {
                this.starters = starters;
            }
        }
    }

    public ArrayList<Player> getStarters() {
        return starters;
    }

    public void printStarters() {
        printPlayerList(starters);
    }

    public ArrayList<Player> getPlayersOnlyList() {
        ArrayList<Player> active = new ArrayList<Player>();
        for (Player player : players) {
            if (player != null) {
                active.add(player);
            }
        }
        return active;
    }

    public static double calculateTeamAverageGoals(ArrayList<Player> players, SeasonType season, int year) {
        if (season == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (players == null || players.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Player player : players) {
            if (player != null) {
                total += player.getTotal(StatType.SHOTS_SCORED, season, year, StatSource.GAME);
            }
        }
        return total / players.size();
    }

    public double getTeamTotalGoals() {
        double total = 0;
        for (Player player : players) {
            if (player != null) {
                total += player.getTotal(StatType.SHOTS_SCORED, this.season, this.teamYear, StatSource.GAME);
            }
        }
        return total;
    }

    public double getTeamTotal(StatType type, StatSource source) {
        if (season == null || type == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        double total = 0;
        for (Player player : players) {
            if (player != null) {
                total += player.getTotal(type, this.season, this.teamYear, source);
            }
        }
        return total;
    }

    public ArrayList<Player> getSortedPlayers(String criteria, StatType stat, boolean ascending, int filterYear,
            StatSource source) {
        if (source == null || criteria == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        ArrayList<Player> active = getPlayersOnlyList();
        int n = active.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Player p1 = active.get(j);
                Player p2 = active.get(j + 1);

                double val1 = 0;
                double val2 = 0;
                boolean isStringSort = false;
                String name1 = "";
                String name2 = "";

                if (criteria.equalsIgnoreCase("name")) {
                    isStringSort = true;
                    name1 = p1.getName();
                    name2 = p2.getName();
                } else if (criteria.equalsIgnoreCase("pb50")) {
                    val1 = p1.getPb50m();
                    val2 = p2.getPb50m();
                } else if (criteria.equalsIgnoreCase("stat")) {
                    int yearToUse = filterYear;
                    if (yearToUse == 0) {
                        yearToUse = this.teamYear;
                    }
                    val1 = p1.getTotal(stat, this.season, yearToUse, source);
                    val2 = p2.getTotal(stat, this.season, yearToUse, source);
                } else if (criteria.equalsIgnoreCase("impact")) {
                    val1 = p1.getImpactScore();
                    val2 = p2.getImpactScore();
                }

                boolean shouldSwap = false;
                if (isStringSort) {
                    int compareResult = name1.compareTo(name2);
                    if (ascending) {
                        if (compareResult > 0)
                            shouldSwap = true;
                    } else {
                        if (compareResult < 0)
                            shouldSwap = true;
                    }
                } else {
                    if (ascending) {
                        if (val1 > val2)
                            shouldSwap = true;
                    } else {
                        if (val1 < val2)
                            shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    active.set(j, p2);
                    active.set(j + 1, p1);
                }
            }
        }
        return active;
    }

    public void recordGame(boolean won) {
        if (won) {
            wins++;
        } else {
            losses++;
        }
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public double getWinPercentage() {
        if (wins + losses == 0) {
            return 0;
        }
        return (double) wins / (wins + losses);
    }

    public static void printPlayerList(ArrayList<Player> players) {
        for (Player player : players) {
            if (player != null) {
                System.out.println(player.getName());
            }
        }
    }
}