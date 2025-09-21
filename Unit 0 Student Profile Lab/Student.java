public class Student {
    private String name; 
    private String id;
    private int grade;

    public Student(String name, int grade) {
        this.name = name; 
        this.grade = grade;
    }

    public Student(String name) {
        this.name.equals(name);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setId(String id) {
        this.id = generateId();
    }

    public String getId() {
        return id;
    }

    public String toString() { 
        return name + " is a " + grade + "th grade student. Their id is " + id + "."; 
    }

    public boolean equals(Student other) {
        if (this.name.equals(other.name)
        && this.grade == other.grade
        && this.id.equals(other.id)){
            return true;
        }

        return false;
    }

    public void generateId() {
        this.id = (int) (Math.random() * ()); // Math.random() [diff of range +1 so it can include max] + [min]
    }
}
