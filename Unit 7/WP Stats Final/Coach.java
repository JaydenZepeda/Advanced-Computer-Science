import java.util.ArrayList;

public class Coach extends Player {
    private ArrayList<Team> teams;

    public Coach(String name) {
        super(name, Position.COACH);
        teams = new ArrayList<Team>();
    }

    public Coach(String name, ArrayList<Team> teams) {
        super(name, Position.COACH);
        this.teams = teams;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team t) {
        for (Team team : teams) {
            if (team.getTeamName().equals(t.getTeamName())) {
                return;
            }
        }
        teams.add(t);
    }

    public double getTeamStat(String teamName, StatType type, StatSource source) {
        for (Team t : teams) {
            if (t.getTeamName().equalsIgnoreCase(teamName))
                return t.getTeamTotal(type, source);
        }
        return 0;
    }

    public ArrayList<Player> getRecommendedStarters(Team team) {
        ArrayList<Player> recStarters = new ArrayList<Player>(6);
        ArrayList<Player> impactTeam = team.getSortedPlayers("impact", null, true, 0, StatSource.BOTH);
        for (int i = 0; i < 6; i++) {
            recStarters.add(i, impactTeam.get(i));
        }
        return recStarters;
    }
}
