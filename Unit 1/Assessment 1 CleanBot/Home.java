public class Home {
    private String address;
    private String ownerName;
    private String username;
    private int cleanlinessLevel;
    private boolean isScheduled;

    public Home(String address, String ownerName, int cleanlinessLevel) {
        this.address = address;
        this.ownerName = ownerName;
        this.username = CleanUtils.generateUsername(ownerName);
        this.cleanlinessLevel = CleanUtils.validateCleanlinessLevel(cleanlinessLevel);
        this.isScheduled = false;
    }

    public Home() {
        this.address = "12345 Coldwater";
        this.ownerName = "Joe Ma";
        this.username = CleanUtils.generateUsername(ownerName);
        this.cleanlinessLevel = 5;
        this.isScheduled = false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = CleanUtils.fixName(ownerName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = CleanUtils.validateCleanlinessLevel(cleanlinessLevel);
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public String toString() {
        String l1 = "== ABOUT HOME ==\n";
        String l2 = "Address: " + address + "\n";
        String l3 = "Owner: " + ownerName + "\n";
        String l4 = "Username: " + username + "\n";
        String l5 = "Cleanliness Level: " + cleanlinessLevel + "\n";
        String yn = "";
        if (isScheduled == false) {
            yn = "No";
        } else {
            yn = "Yes";
        }
        String l6 = "Is scheduled for cleaning? " + yn;
        return l1 + l2 + l3 + l4 + l5 + l5 + l6;
    }
    
    public boolean equals(Home other) {
        if (this.toString().equals(other.toString())) {
            return true;
        }
        return false;
    }
}
