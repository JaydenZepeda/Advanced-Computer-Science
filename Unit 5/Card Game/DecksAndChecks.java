import java.util.ArrayList;
import java.util.Scanner;

public class DecksAndChecks {

    // ----------------------------
    // CHECKERS (students implement)
    // ----------------------------

    // Rule: no single card may have more than 1 ability
    public static boolean checkOneAbilityPerCard(ArrayList<Card> deck) {
        for (Card card : deck) {
            if (card.abilityCount() > 1) {
                return false;
            }
        }
        return true;
    }

    // Rule: no more than 3 total ability cards in the deck
    public static boolean checkNoMoreThanThreeAbilityCards(ArrayList<Card> deck) {
        int abilityCount = 0;
        for (Card card : deck) {
            abilityCount += card.abilityCount();

        }
        if (abilityCount < 3) {
            return true;
        } else {
            return false;
        }
    }

    // Rule: no duplicate abilities in the deck (max one BASTION, one RIPPLE, one
    // CLEAVE)
    public static boolean checkNoDuplicateAbilities(ArrayList<Card> deck) {
        int b = 0;
        int r = 0;
        int c = 0;
        for (Card card : deck) {
            if (card.hasBastion()) {
                b++;
            } else if (card.hasCleave()) {
                c++;
            } else if (card.hasRipple()) {
                r++;
            }
        }
        if (b > 1 || r > 1 || c > 1) {
            return false;
        } else {
            return true;
        }
    }

    // Rule: strength and toughness must be 1..5, and strength+toughness <= 6
    public static boolean checkStatsInRange(ArrayList<Card> deck) {
        for (Card card : deck) {
            if (card.getStrength() > 5 || card.getStrength() < 1 || card.getToughness() > 5 || card.getToughness() < 1
                    || card.getStrength() + card.getToughness() > 6) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDeck(ArrayList<Card> deck) {
        if (deck.size() == 5 && DecksAndChecks.checkOneAbilityPerCard(deck)
                && DecksAndChecks.checkNoMoreThanThreeAbilityCards(deck)
                && DecksAndChecks.checkNoDuplicateAbilities(deck)
                && DecksAndChecks.checkStatsInRange(deck)) {
            return true;
        }
        return false;
    }

    // ----------------------------
    // DECK BUILDERS (students implement)
    // ----------------------------

    // Must create 5 cards, all 3/3, no abilities
    // If the user doesn't want to input a custom deck, this method should return
    // deck
    // of your choice for them to play with.
    public static ArrayList<Card> buildDefaultDeck() {
        ArrayList<Card> def = new ArrayList<Card>();
        def.add(new NamedCard("Card 1", CardType.BLADE, 3, 3, false, false, false));
        def.add(new NamedCard("Card 2", CardType.GRANITE, 3, 3, false, false, false));
        def.add(new NamedCard("Card 3", CardType.PARCHMENT, 3, 3, false, false, false));
        def.add(new NamedCard("Card 4", CardType.BLADE, 3, 3, false, false, false));
        def.add(new NamedCard("Card 5", CardType.GRANITE, 3, 3, false, false, false));
        return def;
    }

    // Prompts the user 5 times using Scanner and validates inputs.
    // Required prompt order per card:
    // name, type, strength, toughness, bastion(y/n), ripple(y/n), cleave(y/n)
    public static ArrayList<Card> buildUserDeck(Scanner sc) {
        ArrayList<Card> deck = new ArrayList<Card>(5);
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            boolean good = false;
            while (!good) {
                System.out.println("== Card " + (i + 1) + " ==");
                System.out.println("Enter name(single word): ");
                String name = scan.next();
                System.out.println("Enter type(Granite, Parchment, or Blade): ");
                CardType type = CardType.fromText(scan.next());
                System.out.println("Enter Strength(1-5): ");
                int strength = Integer.parseInt(scan.next());
                System.out.println("Enter Toughness(1-5): ");
                int toughness = Integer.parseInt(scan.next());
                System.out.println("Bastion?(y/n): ");
                boolean bastion = isYes(scan.next());
                System.out.println("Ripple?(y/n): ");
                boolean ripple = isYes(scan.next());
                System.out.println("Cleave?(y/n): ");
                boolean cleave = isYes(scan.next());
                deck.add(i, new NamedCard(name, type, strength, toughness, bastion, ripple, cleave));
                if (isValidDeck(deck) && name != null & type != null) {
                    good = true;
                } else {
                    deck.remove(deck.size() - 5 + i);
                }
            }
        }
        scan.close();
        return deck;
    }

    // ----------------------------
    // Optional helpers you may use
    // ----------------------------

    public static boolean isYes(String s) {
        if (s == null)
            return false;
        s = s.trim().toLowerCase();
        return s.equals("y") || s.equals("yes");
    }
}
