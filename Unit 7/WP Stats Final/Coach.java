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
        teams.add(t);
    }

    public double getTeamStat(String teamName, StatType type, StatSource source) {
        for (Team t : teams) {
            if (t.getTeamName().equalsIgnoreCase(teamName))
                return t.getTeamTotal(type, source);
        }
        return 0;
    }
}
