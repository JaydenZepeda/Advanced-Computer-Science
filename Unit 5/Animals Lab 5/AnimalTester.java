public class AnimalTester {
    public static void main(String[] args) {
        Hawk hawk = new Hawk(2, "Hawk", 3, 3);

        hawk.ageUp(1);
        System.out.println(hawk.getAge());

    }
}
