public class SkyViewTester {
    public static void main(String[] args) {
        double[] scanned = new double[] { 0.3, 0.7, 0.8, 0.4, 1.4, 1.1 };
        SkyView skyView1 = new SkyView(3, 2, scanned);
        SkyView skyView2 = new SkyView(3, 2, scanned);

        System.out.println(skyView1.toString());

        System.out.println(skyView1.equals(skyView2));
    }
}
