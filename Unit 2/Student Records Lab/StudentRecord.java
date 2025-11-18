public class StudentRecord {
    // instance variables
    private String name;
    private int[] scores;

    // constructors
    public StudentRecord(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    

    // getters
    // to-do: implement getters
    // to-do: implement getTestScore

    // inherited methods
    // to-do: implement toString

    // methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public static String printIntegerArray(int[] array) {
        if (array == null || array.length == 0) {
            return "Array is empty";
        }
        String string = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                string += array[i] + "]";
            } else {
                string += array[i] + ", ";   
            }
        }
        System.out.println(string);
        return string;
    }

    public String toString() {
        return name + "'s scores: " + printIntegerArray(scores);
    }

    public boolean equals(StudentRecord other) {
        if (scores.equals(other.getScores()) && name.equals(other.getName())) {
            return true;
        }
        return false;
    }

    /*
     * returns the average (arithmetic mean) of the values in scores
     * precondition: 0 <= first < last < scores.length
     * 
     * @param first - the first index of the scores array
     * 
     * @param last - the last index of the scores array
     * 
     * @return the double average of the values in scores
     */

    public double getAverage(int first, int last) {
        double total = 0;
        for (int i = first; i < last; i++) {
            total += scores[i];
        }
        double avg = total / (last - first);
        return avg;
    }

    public int getTestScore(int testNumber) {
        if (scores.length - 1 <= testNumber || testNumber < 0) {
            return - 1;
        }
        return scores[testNumber];
    }

    /*
     * Determines if each successive value in scores is greater
     * than or equal to the previous value
     * 
     * @return true if student has improved, false otherwise
     */
    public boolean hasImproved() {
        int temp = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < temp) {
                return false;
            }
            temp = scores[i];
        }
        return true;
    }

    /*
     * The method determines if the student has improved and returns the average
     * score appropriately:
     * If the student has improved, returns the average
     * of the top half of the scores array.
     * Otherwise, returns the average of all of the values in scores
     * 
     * @return the double average of test scores
     */

    public double getFinalAverage() {
        if (hasImproved()) {
            return getAverage(scores.length / 2, scores.length);
        }
        return getAverage(0, scores.length);
    }

}