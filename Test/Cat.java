public class Cat { //p made lower case and no s to match with file name
	private String name;
	private String breed;
	private boolean isHungry;
	private int livesRemaining;
	
	// 2-Parameter Constructor
	public Cat(String name, String breed) { // add 2nd parameter and made cat Cat
		this.name = name; //add this.
		this.breed = breed; // add this.
		this.isHungry = true; // yes is turned into boolean
		livesRemaining = 9;
	}

	public String getName() { // return is a string
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsHungry(){ // return is a boolean and made it camel case
		return isHungry;
	}

	public boolean feed() {
		this.isHungry = false;
		return isHungry; // added return(boolean)
	}

	public boolean equals(Cat other) {
		if (this.name.equals(other.name) && this.breed.equals(other.breed)// made an if and == into .equals
			&& this.livesRemaining == other.livesRemaining) {// made = ==
				return true;// added return
		} 
		return false;// added return
	}

	public String toString() {
		return name + " is of breed " + breed + " and has " + livesRemaining + " lives remaining.";// added return and took away print line
	}
}