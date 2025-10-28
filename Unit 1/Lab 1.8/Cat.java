public class Cat {
    private String name;
    private String ownerName;
    private int moodLevel;
    private String catId;
    private char catChar;
    private boolean isHungry;

    public Cat(Srting name, String ownerName, int moodLevel, String catId) {
        this.moodLevel = PurrfectUtils.validateMoodLevel();
        this.ownerName = ownerName;
        this.name = name;
        this.catId = PurrfectUtils.validatedCatId();
        this.catChar = PurrfectUtils.generateCatChar();
        this.isHungry = true;
    }

    public Cat() {
        this.moodLevel = 10;
        this.ownerName = "John";
        this.name = "Jake";
        this.catId = "1234";
        this.catChar = PurrfectUtils.generateCatChar();
        this.isHungry = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = PurrfectUtils.validateMoodLevel();
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = PurrfectUtils.validatedCatId();
    }

    public char getCatChar() {
        return catChar;
    }

    public void setCatChar(char catChar) {
        this.catChar = catChar;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public String generateCatTag() {
        return catId + catChar;
    }

    public String toString() {
        String L1 = "== ABOUT " + name.toUpperCase() + " ==\n";
        String L2 = name + " is a cat.\n"
        String L3_4 = PurrfectUtils.determineCatMood(this);
        return L1 + L2 + L3_4;
    }

    public boolean equals(Cat other) {
        if (this.generateCatTag.equals(other.generateCatTag())
            && this.name.equals(other.name)
            && this.ownerName.equals(other.ownerName)
            && this.moodLevel == other.moodLevel
            && this.isHungry == other.isHungry) {
                return true
            }
        return false;
    }
    
}
