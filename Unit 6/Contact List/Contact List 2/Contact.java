public class Contact {
    private String firstName;
    private String lastName;
    private String telephoneNumber;

    public Contact(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = verifyNumber(telephoneNumber);
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
        this.telephoneNumber = verifyNumber(telephoneNumber);
    }

    public int compareTo(Contact other) {
        if (this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase()) < 0
                || this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase()) < 0
                || telephoneNumber.compareTo(other.telephoneNumber) < 0) {
            return -1;
        } else if (this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase()) > 0
                || this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase()) > 0
                || telephoneNumber.compareTo(other.telephoneNumber) > 0) {
            return 1;
        } else if (this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase()) == 0
                || this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase()) == 0
                || telephoneNumber.compareTo(other.telephoneNumber) == 0) {
            return 0;
        }
        return 0;
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n #: " + telephoneNumber;
    }

    public String verifyNumber(String telephoneNumber) {
        String number = "";
        String finalNum = "";
        for (int i = 0; i < telephoneNumber.length(); i++) {
            if (!telephoneNumber.substring(i, i + 1).equals("-")) {
                number += telephoneNumber.substring(i, i + 1);
            }
        }
        for (int index = 0; index < number.length(); index++) {
            if (index == 2 || index == 5) {
                finalNum += number.substring(index, index + 1) + "-";
            } else {
                finalNum += number.substring(index, index + 1);
            }
        }
        return finalNum;
    }
}
