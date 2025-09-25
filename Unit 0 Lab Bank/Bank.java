public class Bank {
    private int numberOfTellers;
    private int numberOfLoanOfficers;
    
    public Bank(int numberOfLoanOfficers, int numberOfTellers) {
        this.numberOfLoanOfficers = numberOfLoanOfficers;
        this.numberOfTellers = numberOfTellers;
    }

    public int getNumberOfLoanOfficers() {
        return numberOfLoanOfficers;
    }

    public void setNumberOfLoanOfficers(int numberOfLoanOfficers) {
        this.numberOfLoanOfficers = numberOfLoanOfficers;
    }

    public int getNumberOfTellers() {
        return numberOfTellers;
    }

    public void setNumberOfTellers(int numberOfTellers) {
        this.numberOfTellers = numberOfTellers;
    }

    public int computeTotalEmployees() {
        return numberOfLoanOfficers + numberOfTellers;
    }

    public String toString() {
        return "This bank has " + numberOfLoanOfficers + " loan officers and " 
            + numberOfTellers + " tellers.";
    }

    public boolean equals(Bank other) {
        if (numberOfLoanOfficers == other.numberOfLoanOfficers
            && numberOfTellers == other.numberOfTellers) {
            return true;
        }
        return false;
    }

    public void hireMembers(int numberToHire, boolean isLoanOfficer) {
        if (isLoanOfficer == true) {
            this.numberOfLoanOfficers += numberToHire;
        } else {
            this.numberOfTellers += numberToHire;    
        }
    }

    public double getEmployeeRatio() {
        return (double) numberOfLoanOfficers / numberOfTellers;
    }

    public void fireMembers(int numberToFire, boolean isLoanOfficer) {
if (isLoanOfficer == true 
        && numberToFire <= numberOfLoanOfficers) {
            this.numberOfLoanOfficers -= numberToFire;
        } else {
            if (numberToFire <= numberOfTellers) {
               this.numberOfTellers -= numberToFire; 
            }    
        }
        System.out.println("You do not enough employees to fire " + numberToFire + " loan officers or tellers.");
    }
}
