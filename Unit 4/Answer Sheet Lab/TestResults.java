import java.util.ArrayList;

public class TestResults {
    private ArrayList<String> answerKey;
    private ArrayList<StudentAnswerSheet> submissions;

    public TestResults(ArrayList<String> key, ArrayList<StudentAnswerSheet> submissions) {
        if (key == null || submissions == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.answerKey = key;
        this.submissions = submissions;
    }

    public ArrayList<String> getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(ArrayList<String> answerKey) {
        this.answerKey = answerKey;
    }

    public ArrayList<StudentAnswerSheet> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(ArrayList<StudentAnswerSheet> submissions) {
        this.submissions = submissions;
    }

    public void submit(StudentAnswerSheet student) {
        submissions.add(student);
    }

    public void gradeTests() {
        for (StudentAnswerSheet student : submissions) {
            student.setTestScore(student.getGrade(answerKey));
        }
    }

    public String highestScoringStudent() {
        if (submissions.size() == 0 || submissions == null) {
            return "";
        }
        StudentAnswerSheet scoreStudent = submissions.get(0);
        for (StudentAnswerSheet students : submissions) {
            if (students.getGrade(answerKey) > scoreStudent.getGrade(answerKey)) {
                students = scoreStudent;
            }
        }
        return scoreStudent.getName();
    }
}
