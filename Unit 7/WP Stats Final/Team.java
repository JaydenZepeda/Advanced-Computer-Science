import java.util.*;

public class Team {
    private ArrayList<Player> players;
    private String teamName;

    public Team(String name) {
        teamName = name;
        players = new ArrayList<Player>();
    }

    public Team(String name, ArrayList<Player> players) {
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
        this.teamName = teamName;
    }

    public void addPlayer(Player player, int capNumber) {
        players.add(capNumber, player);
    }

}