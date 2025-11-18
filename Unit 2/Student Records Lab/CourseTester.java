public class CourseTester {
    public static void main(String[] args) {
        int [] arr = {90, 89, 91, 95};
        StudentRecord ana = new StudentRecord("Ana", arr);
        System.out.println(ana.toString().equals("Ana's scores: [90, 89, 91, 95]"));
        System.out.println(ana.getAverage(0, 3) == 91.25);
        System.out.println(ana.getTestScore(1) == 89);
        
    }
}
