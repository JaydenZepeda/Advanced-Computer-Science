public class Student {
    private String name; 
    private String id;
    private int grade;

    public Student(String name, int grade) {
        this.name = name; 
        this.grade = grade;
        this.id = generateId();
    }

    public Student(String name) {
        this.name = name;
        this.grade = 10;
        this.id = generateId();
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
        this.id = id;
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
            && this.id.equals(other.id)) {
            return true;
        }

        return false;
    }

    public String generateId() {
        int n1 = (int) (Math.random() * 8 + 1);
        int n2 = (int) (Math.random() * 8 + 1); 
        int n3 = (int) (Math.random() * 8 + 1); 
        int n4 = (int) (Math.random() * 10);
        int n5 = (int) (Math.random() * 10);
        int n6 = (int) (Math.random() * 10);
        int n7 = (int) (Math.random() * 10);
        this.id = "" + n1 + n2 + n3 + "-" + n4 +  + n5 + n6 + n7; 
        return this.id;
        // Math.random() [diff of range +1 so it can include max] + [min]
    }
    
}
