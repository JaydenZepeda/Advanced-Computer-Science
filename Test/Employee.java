public class Employee {
    private String name;
    private String jobTitle;
    private double salary;
    
    public Employee(String name, String jobTitle, double salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + ", Job Title: " + jobTitle + ", Salary: " + salary; 
    }

    public boolean equals(Employee other) {
        if (this.name.equals(other.name) 
            && this.jobTitle.equals(other.jobTitle)
            && this.salary == other.salary) {
                return true;
            }
        return false;
    }

    public void raiseSalary(double Percentage) {
        this.salary =  salary * (1 + Percentage / 100);
    }
}
