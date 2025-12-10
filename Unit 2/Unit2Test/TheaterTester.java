public class TheaterTester {
    public static void main(String[] args) {
        TheaterMember member1 = new TheaterMember("John");
        TheaterMember member2 = new TheaterMember("jake");
        Theater theater1 = new Theater("amc", 4);
        theater1.registerMember(member1);
        theater1.registerMember(member2);
        System.out.println(theater1.toString());
    }
}
