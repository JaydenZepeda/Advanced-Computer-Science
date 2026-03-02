import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardBattleGame {

    // Must print:
    // == CARD CLASH ==
    // Starting: Player/Bot
    // Winner: Player/Bot
    public static String playGame(ArrayList<Card> playerDeck, ArrayList<Card> botDeck, Random rng) {
        String starter = "";
        PlayerState player = new PlayerState("Player", playerDeck);
        PlayerState bot = new PlayerState("Bot", botDeck);
        String winner = "";
        if (rng.nextInt() % 2 > 0.5) {
            starter = "Player";
            for (int i = 0; i < 50; i++) {
                drawAndPlayIfNeeded(player, bot);
                attackOnce(player, bot);
                if (player.deck.size() == 0 || player.deck == null) {
                    winner = "Bot";
                    i = 100;
                } else if (bot.deck.size() == 0 || bot.deck == null) {
                    winner = "Player";
                    i = 100;
                }
                drawAndPlayIfNeeded(bot, player);
                attackOnce(bot, player);

            }
        } else {
            starter = "Bot";
            for (int i = 0; i < 50; i++) {
                drawAndPlayIfNeeded(bot, player);
                attackOnce(bot, player);
                if (player.deck.size() == 0 || player.deck == null) {
                    winner = "Bot";
                    i = 100;
                } else if (bot.deck.size() == 0 || bot.deck == null) {
                    winner = "Player";
                    i = 100;
                }
                drawAndPlayIfNeeded(player, bot);
                attackOnce(player, bot);

            }
        }

        String l1 = "== CARD CLASH ==\n";
        String l2 = "Starting: " + starter + "\n";
        String l3 = "Winner: " + winner;
        return l1 + l2 + l3;
    }

    // ----- helpers you may implement or use -----

    // Draw top card if no active, apply on-play effects
    public static void drawAndPlayIfNeeded(PlayerState self, PlayerState other) {
        if ((self.active == null || self.active.isDefeated()) && self.hasAnythingLeft()) {
            self.deck.removeIf(card -> card.isDefeated());
            if (self.deck.size() > 0) {
                self.active = self.deck.get(0);
                self.deck.get(0).applySelfOnPlay(self.deck.get(0).resolvedAbility());
            }
        }
        if ((other.active == null || other.active.isDefeated()) && other.hasAnythingLeft()) {
            other.deck.removeIf(card -> card.isDefeated());
            if (other.deck.size() > 0) {
                other.active = other.deck.get(0);
                other.deck.get(0).applySelfOnPlay(other.deck.get(0).resolvedAbility());
            }
        }
    }

    // One attack (self active attacks other active if both exist)
    public static void attackOnce(PlayerState attacker, PlayerState defender) {
        if (attacker.hasAnythingLeft() && defender.hasAnythingLeft()) {
            int dam = attacker.active.computeDamageAgainst(defender.active);
            defender.active.takeDamage(dam);
        }
    }

    // Optional local run (not graded)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Card> player = DecksAndChecks.buildDefaultDeck();
        ArrayList<Card> bot = BotFactory.buildBotDeck();

        if (!DecksAndChecks.isValidDeck(player)) {
            System.out.println("Player deck invalid!");
            return;
        }

        System.out.println(playGame(player, bot, new Random()));
    }
}