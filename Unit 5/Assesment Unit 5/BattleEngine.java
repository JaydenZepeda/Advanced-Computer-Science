// a class for all of the battle engine functions
// this class will be used to validate the type, element, weakness, health, and attack of the
// monsters
// there's also methods that will be used to calculate the damage and the health of the monsters
// and apply the type advantage multipliers

import java.util.ArrayList;

public class BattleEngine {

    // to-do: validateStats
    // checks if the monster stats are valid
    // the total combined stats of the monster should not exceed 250
    public static boolean validateStats(Monster monster) {
        if (monster.getTotalStatSum() <= 250) {
            return true;
        }
        return false;
    }

    // to-do: validateElement
    // checks if the monster element is valid
    // the only valid types allowed are "Fire", "Water", "Earth", and "Air"
    public static boolean validateElement(Monster monster) {
        if (monster.getElement() == ElementType.AIR || monster.getElement() == ElementType.FIRE
                || monster.getElement() == ElementType.WATER || monster.getElement() == ElementType.EARTH) {
            return true;
        }
        return false;
    }

    // to-do: correctStats
    // checks if stats are invalid
    // fixes them so they are valid, however you choose
    public static void correctStats(Monster monster) {
        if (validateStats(monster) == false) {
            monster.setAttack(50);
            monster.setDefense(50);
            monster.setHealth(50);
            monster.setSpeed(50);
        }
    }

    // to-do: startBattle
    // each monster takes turn attacking the other until a monster's hp reaches 0.
    // It returns the
    // winning monster.
    public static Monster startBattle(Monster monster1, Monster monster2) {
        boolean noWinner = true;
        Monster winner = monster1;
        if (monster1 == null || !validateStats(monster1) || !validateElement(monster1)) {
            return monster2;
        }
        if (monster2 == null || !validateStats(monster2) || !validateElement(monster2)) {
            return monster1;
        }
        if (monster2 == null || !validateStats(monster2) || !validateElement(monster2) && monster1 == null
                || !validateStats(monster1) || !validateElement(monster1)) {
            return null;
        }
        if (monster1.speed > monster2.speed) {
            while (noWinner) {
                monster1.attack(monster2);
                displayStatus(monster1, monster2);
                if (monster2.getHealth() <= 0) {
                    winner = monster1;
                    noWinner = false;
                }
                monster2.attack(monster1);
                displayStatus(monster2, monster1);
                if (monster1.getHealth() <= 0) {
                    winner = monster2;
                    noWinner = false;
                }
            }
        }
        if (monster2.speed > monster1.speed) {
            while (noWinner) {
                monster2.attack(monster1);
                displayStatus(monster2, monster1);
                if (monster1.getHealth() <= 0) {
                    winner = monster2;
                    noWinner = false;
                }
                monster1.attack(monster2);
                displayStatus(monster1, monster2);
                if (monster2.getHealth() <= 0) {
                    winner = monster1;
                    noWinner = false;
                }
            }
        }
        System.out.println(winner.victoryNoise());
        return winner;
    }

    // to-do: displayStatus
    // method prints out the current health of each monster.
    public static void displayStatus(Monster monster, Monster opponent) {
        System.out.println("Chimney the Chimera: 50 health vs Truant the Treant: 10 health");
    }

}
