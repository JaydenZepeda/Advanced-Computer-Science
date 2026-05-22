import java.time.LocalDate;
import java.util.ArrayList;

public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("--- WATER POLO STATS SYSTEM TESTER ---");

        Coach coach = new Coach("Coach Smith");
        Team varsity = new Team("Varsity", 20, SeasonType.HIGH_SCHOOL, 2024);
        Team club = new Team("Elite Club", 20, SeasonType.CLUB, 2024);

        coach.addTeam(varsity);
        coach.addTeam(club);

        Player p1 = new Player("Alice", Position.LEFT_SIDE_ATTACKER);
        Player p2 = new Player("Bob", Position.GOALIE);
        Player p3 = new Player("Charlie", Position.CENTER);

        p1.addStat(new GameStat(StatType.SHOTS_SCORED, 3, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));
        p1.addStat(new GameStat(StatType.ASSISTS, 1, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));
        p1.addStat(new GameStat(StatType.GAMES_PLAYED, 1, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));

        p1.addStat(new GameStat(StatType.SHOTS_SCORED, 2, LocalDate.of(2024, 2, 1), SeasonType.CLUB, "Bears",
                Tournament.FUTURES_LEAGUE));
        p1.addStat(new GameStat(StatType.TURN_OVER, 1, LocalDate.of(2024, 2, 1), SeasonType.CLUB, "Bears",
                Tournament.FUTURES_LEAGUE));
        p1.addStat(new GameStat(StatType.GAMES_PLAYED, 1, LocalDate.of(2024, 2, 1), SeasonType.CLUB, "Bears",
                Tournament.FUTURES_LEAGUE));

        p1.addStat(new PracticeStat(StatType.METERS_SWAM, 1000, LocalDate.of(2024, 1, 11), SeasonType.HIGH_SCHOOL,
                "Conditioning"));
        p1.addStat(new PracticeStat(StatType.PRACTICES, 1, LocalDate.of(2024, 1, 11), SeasonType.HIGH_SCHOOL,
                "Conditioning"));

        p2.addStat(new GameStat(StatType.SAVES, 15, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));
        p2.addStat(new GameStat(StatType.GAMES_PLAYED, 1, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));

        p3.addStat(new GameStat(StatType.SHOTS_SCORED, 20, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));
        p3.addStat(new GameStat(StatType.GAMES_PLAYED, 1, LocalDate.of(2024, 1, 10), SeasonType.HIGH_SCHOOL, "Tigers",
                Tournament.CIF));

        varsity.addPlayer(p1, 5);
        varsity.addPlayer(p2, 1);
        varsity.addPlayer(p3, 2);

        System.out.println("\n--- Testing Player Methods ---");
        System.out.println("Alice Combined Goals: " + p1.getTotalCombined(StatType.SHOTS_SCORED, StatSource.BOTH));
        System.out.println(
                "Alice HS Goals: " + p1.getTotal(StatType.SHOTS_SCORED, SeasonType.HIGH_SCHOOL, 2024, StatSource.GAME));
        System.out.println("Alice Tournament Goals (State): "
                + p1.getTotalForTournament(StatType.SHOTS_SCORED, Tournament.CIF, 2024));

        p1.updatePb50m(30.5);
        p1.updatePb50m(29.8); // Should update
        System.out.println("Alice PB 50m: " + p1.getPb50m());

        double rangeAvg = p1.getAverageInRange(StatType.SHOTS_SCORED, LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 31), SeasonType.HIGH_SCHOOL, StatSource.GAME);
        System.out.println("Alice Jan Average Goals: " + rangeAvg);

        System.out.println("\n--- Testing Team Methods ---");
        varsity.recordGame(true);
        varsity.recordGame(false);
        System.out.println("Varsity Win %: " + varsity.getWinPercentage());
        System.out.println("Varsity Total Goals: " + varsity.getTeamTotalGoals());

        System.out.println("\n--- Testing Sorting (Impact Score - Descending) ---");
        ArrayList<Player> sortedImpact = varsity.getSortedPlayers("impact", null, false, 0, StatSource.GAME);
        for (Player p : sortedImpact) {
            System.out.println(p.getName() + " Impact: " + p.getImpactScore());
        }

        System.out.println("\n--- Testing Sorting (Name - Ascending) ---");
        ArrayList<Player> sortedName = varsity.getSortedPlayers("name", null, true, 0, StatSource.GAME);
        for (Player p : sortedName) {
            System.out.println(p.getName());
        }

        System.out.println("\n--- Testing Coach Methods ---");
        System.out.println("Coach managed teams count: " + coach.getTeams().size());
        System.out.println(
                "Varsity Goals via Coach: " + coach.getTeamStat("Varsity", StatType.SHOTS_SCORED, StatSource.GAME));

        System.out.println("\nAll-Time Top Scorer: " + Player.allTimeTopScorer.getName());
        p1.printStatSheet();
    }
}
