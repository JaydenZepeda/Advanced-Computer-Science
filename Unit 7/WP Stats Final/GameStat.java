import java.time.LocalDate;

public class GameStat extends BaseStat {
    private String opponent;
    private Tournament tournament;

    public GameStat(StatType stat, double value, LocalDate date, SeasonType season, String opponent,
            Tournament tournament) {
        super(stat, value, date, season);
        this.opponent = opponent;
        this.tournament = tournament;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        if (opponent == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.opponent = opponent;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        if (tournament == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.tournament = tournament;
    }

    @Override
    public StatSource getSource() {
        return StatSource.GAME;
    }

}
