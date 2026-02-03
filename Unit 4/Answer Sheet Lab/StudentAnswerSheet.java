import java.util.ArrayList;

public class StudentAnswerSheet {
    private String name;
    private double testScore;
    private ArrayList<String> answers;

    public StudentAnswerSheet(String name, ArrayList<String> answers) {
        this.name = name;
        this.answers = answers;
        this.testScore = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public double getGrade(ArrayList<String> key) {
        if (answers == null || key == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int correct = 0;
        int incorrect = 0;
        for (int i = 0; i < key.size(); i++) {
            if (key.get(i).equals(answers.get(i))) {
                correct++;
            } else if (answers.get(i).equals("?")) {

            } else {
                incorrect++;
            }
        }
        return (double) correct - (incorrect * 0.25);
    }
}