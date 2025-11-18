public class Course {
    // instance variables
    private String courseName;
    private StudentRecord[] enrolledStudents;

    // constructors
    public Course(String courseName, StudentRecord[] enrolledStudents) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public StudentRecord[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(StudentRecord[] enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    
    public String toString() {
        String l1 = "== " + courseName + " ==\n";
        String endingString = "";
        for (int i = 0; i < enrolledStudents.length; i++) {
            endingString += (i + 1) + ".) " + enrolledStudents[i].toString() + "\n";
        }
        return l1 + endingString;
    }

    public String findBestStudent() {
        StudentRecord bestStudent = enrolledStudents[0];
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i].getFinalAverage() > bestStudent.getFinalAverage()) {
                bestStudent = enrolledStudents[i];
            }
        }
        return bestStudent.getName();
    }

    public double calculateTestAverage(int testNumber) {
        double total = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            total += enrolledStudents[i].getTestScore(testNumber);
        }
        double avg = total / (enrolledStudents.length);
        return avg;
    }
    // getters
    // to-do: implement getters

    // setters
    // to-do: implement setters

    // inherited methods

    // to-do: implement toString

    // methods

    /*
     * Iterates through the enrolledStudents array and returns the name of the
     * student with the best final average.
     * 
     * @return the name of the student with the best final average
     */
    // to-do: implement findBestStudent

    /*
     * Iterates through the enrolledStudents array and returns the average of the
     * specified test number.
     * 
     * @return a double representing the average of the specified test number
     */
    // to-do: implement calculateTestAverage

}
