public class BirdMonster extends Monster {

    public BirdMonster(String name, ElementType element, int health, int attack, int defense, int speed,
            String attackNameOne, String attackNameTwo, ElementType attackElementOne, ElementType attackElementTwo) {
        super(name, element, health, attack, defense, speed, attackNameOne, attackNameTwo, attackElementOne,
                attackElementTwo);
    }

    @Override
    public String victoryNoise() {
        return "CAWWW";
    }
}
