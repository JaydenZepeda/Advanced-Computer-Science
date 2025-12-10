public class TheaterMember {
    private String name;
    private boolean[] loyaltyCredits;

    public TheaterMember(String name) {
        this.name = name;
        this.loyaltyCredits = new boolean[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean[] getLoyaltyCredits() {
        return loyaltyCredits;
    }

    public void setLoyaltyCredits(boolean[] loyaltyCredits) {
        this.loyaltyCredits = loyaltyCredits;
    }

    public void grantLoyaltyCredit() {
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] == false) {
                loyaltyCredits[i] = true;
                i = loyaltyCredits.length;
            }
        }
    }

    public int countLoyaltyCredits() {
        int count = 0;
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] == true) {
                count++;
            }
        }
        return count;
    }

    public String determineMembershipStatus() {
        if (countLoyaltyCredits() >= 6) {
            return "Gold Member";
        } else if (countLoyaltyCredits() >= 3 && countLoyaltyCredits() <= 5) {
            return "Silver Member";
        } else {
            return "Plus Member";
        }
    }

    public String loyaltyHistory() {
        String string = "Loyalty History: [";
        for (int i = 0; i < countLoyaltyCredits(); i++) {
            string += "X, ";
        }
        for (int i = 0; i < loyaltyCredits.length - countLoyaltyCredits(); i++) {
            if (i == loyaltyCredits.length - countLoyaltyCredits() - 1) {
                string += "-";
            }
            string += "-, ";
        }
        string += "]";
        return string;
    }

    public String toString() {
        return name + " (" + determineMembershipStatus() + "), " + loyaltyHistory();
    }

    public boolean equals(TheaterMember other) {
        if (name.equals(other.getName()) && countLoyaltyCredits() == other.countLoyaltyCredits()) {
            return true;
        }
        return false;
    }
}