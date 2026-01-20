public class HubTester {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Jayden@", "abc", "@abc.");
        } catch (Exception e) {
            System.out.println(e + " Expected error");
        }
        Student student2 = new Student("Jayden", "abc", "@abc.");
        try {
            Student student3 = new Student("Jayden", "abc", "@abc.");
        } catch (Exception e2) {
            System.out.println(e2 + " Expected error");
        }
        try {
            student2.changeName("jake@");
        } catch (Exception e3) {
            System.out.println(e3 + " Expected error");
        }
        try {
            student2.changeName("Jayden");
        } catch (Exception e4) {
            System.out.println(e4 + " Expected error");
        }
        try {
            Student student4 = new Student(null, null, null);
        } catch (Exception e5) {
            System.out.println(e5 + " Expected error");
        }
        try {
            Student student5 = new Student("", "", null);
        } catch (Exception e6) {
            System.out.println(e6 + " Expected error");
        }
        try {
            Student student6 = new Student("abc", "abc", "abc");
        } catch (Exception e7) {
            System.out.println(e7 + " Expected error");
        }

        Hub hub = new Hub();
        hub.registerStudent("Jake", "123", ".@abc");
        try {
            hub.loginStudent("Joe", "123");
        } catch (Exception e8) {
            System.out.println(e8 + " Expected error");
        }
        try {
            hub.loginStudent("Jake", "111");
        } catch (Exception e9) {
            System.out.println(e9 + " Expected error");
        }
        try {
            hub.doesStudentExist("Jake");
        } catch (Exception e10) {
            System.out.println(e10 + " Expected error");
        }
        Hub hub2 = new Hub();
        try {
            hub.registerStudent("Jake", "123", ".@abc");
        } catch (Exception e11) {
            System.out.println(e11 + " Expected error");
        }
        try {
            hub.registerStudent("@Joe", "abc", ".@abc");
        } catch (Exception e12) {
            System.out.println(e12 + " Expected error");
        }
        try {
            hub.registerStudent(null, null, null);
        } catch (Exception e13) {
            System.out.println(e13 + " Expected error");
        }
        try {
            hub.registerStudent("  ", null, null);
        } catch (Exception e14) {
            System.out.println(e14 + " Expected error");
        }
        try {
            hub.registerStudent("james", "456", "abc");
        } catch (Exception e15) {
            System.out.println(e15 + " Expected error");
        }
        Assignment asnm = new Assignment(null, null);
        try {
            asnm.setDescription(null);
        } catch (Exception e16) {
            System.out.println(e16 + " Expected error");
        }
    }
}
