public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String telephoneNumber;

    public Contact(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = verifyNumberFixNum(telephoneNumber);
        verifyNumber(this.telephoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        if (verifyNumber(telephoneNumber)) {
            this.telephoneNumber = telephoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid Input");
        }
    }

    @Override
    public int compareTo(Contact other) {
        int firstComp = this.firstName.compareToIgnoreCase(other.firstName);
        if (firstComp != 0)
            return firstComp;

        int lastComp = this.lastName.compareToIgnoreCase(other.lastName);
        if (lastComp != 0)
            return lastComp;

        return this.telephoneNumber.compareTo(other.telephoneNumber);
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n #: " + telephoneNumber;
    }

    public String verifyNumberFixNum(String telephoneNumber) {
        if (telephoneNumber == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        String number = "";
        for (int i = 0; i < telephoneNumber.length(); i++) {
            if (Character.isDigit(telephoneNumber.charAt(i))) {
                number += telephoneNumber.charAt(i);
            }
        }
        if (number.length() != 10) {
            throw new IllegalArgumentException("Invalid Input");
        }
        return number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6);
    }

    public boolean verifyNumber(String telephoneNumber) {
        if (telephoneNumber == null || telephoneNumber.length() != 12) {
            throw new IllegalArgumentException("Invalid Input");
        }
        for (int i = 0; i < telephoneNumber.length(); i++) {
            char c = telephoneNumber.charAt(i);
            if (i == 3 || i == 7) {
                if (c != '-') {
                    return false;
                } else {
                    if (!Character.isDigit(c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int compareForLastNameSort(Contact other) {
        int firstComp = this.lastName.compareToIgnoreCase(other.lastName);
        if (firstComp != 0)
            return firstComp;

        int lastComp = this.firstName.compareToIgnoreCase(other.firstName);
        if (lastComp != 0)
            return lastComp;

        return this.telephoneNumber.compareTo(other.telephoneNumber);
    }
}
