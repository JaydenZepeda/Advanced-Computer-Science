public class CatTester {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Jack", "Jake", 3, "1234");
        System.out.println(cat1.toString());
        System.out.println(cat1.getOwnerName());
        System.out.println(cat1.getMoodLevel());
        System.out.println(cat1.isHungry());

        cat1.setCatChar('A');
        cat1.setCatId("1111");
        cat1.setHungry(false);
        cat1.setMoodLevel(4);
        cat1.setName("James");
        cat1.setOwnerName("Jane");

        System.out.println(cat1.toString());
        System.out.println(cat1.getOwnerName());
        System.out.println(cat1.getMoodLevel());
        System.out.println(cat1.isHungry());

        Cat cat2 = new Cat("James", "Jane", 4, "1111");
        cat2.setCatChar('A');
        cat2.setHungry(false);

        System.out.println(cat1.equals(cat2));
        PurrfectUtils.bootUp(cat1);
        PurrfectUtils.pet(cat1);
        for (int i = 0; i < 4; i ++) {
            PurrfectUtils.trimClaws(cat1);
        }
        PurrfectUtils.cleanLitterBox(cat1);
        PurrfectUtils.feed(cat1);
    }
}
