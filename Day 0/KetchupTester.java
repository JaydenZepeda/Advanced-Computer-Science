public class KetchupTester {
    public static void main(String[] args) {
        System.out.println("WSP");
        
        Ketchup packet1 = new Ketchup();
        Ketchup packet2 = new Ketchup();
        packet1.changebrand();
        packet1.smash();
        packet1.open();
        packet1.squirtketchup();
        packet1.squirtketchup();
        
        System.out.println(packet1.toString());
        System.out.println("Are the two ketchup packets the same?");
        System.out.println(packet1.equals(packet2));
    }

    // public int multiply(int a, int b,) {

    // }
}
