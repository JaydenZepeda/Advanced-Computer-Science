public class Theater {
    private String theaterName;
    private TheaterMember[] registeredMembers;

    public Theater(String theaterName, TheaterMember[] registeredMembers) {
        this.theaterName = theaterName;
        this.registeredMembers = registeredMembers;
    }

    public Theater(String theaterName, int initialCapacity) {
        this.theaterName = theaterName;
        this.registeredMembers = new TheaterMember[initialCapacity];
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public TheaterMember[] getRegisteredMembers() {
        return registeredMembers;
    }

    public void setRegisteredMembers(TheaterMember[] registeredMembers) {
        this.registeredMembers = registeredMembers;
    }

    public boolean isFull() {
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void increaseCapacity() {
        TheaterMember[] newArr = new TheaterMember[2 * registeredMembers.length];
        for (int i = 0; i < registeredMembers.length; i++) {
            newArr[i] = registeredMembers[i];
        }
        this.registeredMembers = newArr;
    }

    public void registerMember(TheaterMember member) {
        if (isFull()) {
            increaseCapacity();
        }
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i] == null) {
                registeredMembers[i] = member;
                i = registeredMembers.length;
            }
        }
    }

    public String toString() {
        String l1 = "== " + theaterName + " Members ==";
        String l2 = "";
        for (int i = 0; i < registeredMembers.length; i++) {
            l2 += "" + (i + 1) + ".) " + registeredMembers[i].toString() + "\n";
        }
        return l1 + "\n" + l2;
    }

    public boolean deleteMember(TheaterMember member) {
        for (int i = 0; i < registeredMembers.length; i++) {
            if (registeredMembers[i].equals(member)) {
                registeredMembers[i] = null;
                return true;
            }
        }
        return false;
    }
}