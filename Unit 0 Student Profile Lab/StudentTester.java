public class StudentTester {

    public static void main(String[] args) {
        
        Student student1 = new Student("Eve");
        Student student2 = new Student("Adam", 10);
        Student student3 = new Student("Jack", 11);
        Student student4 = new Student("Dale"); 
        
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        student1.setGrade(11);
        student2.setGrade(11);
        student3.setGrade(12);
        student4.setGrade(11);
        
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        System.out.println(student1.equals(student4)); //false
    }
    
}
