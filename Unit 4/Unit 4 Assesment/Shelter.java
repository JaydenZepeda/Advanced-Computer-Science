import java.util.ArrayList;

public class Shelter {
    // instance variables
    private Dog[][] kennels;

    // constructors
    public Shelter(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        kennels = new Dog[rows][cols];
    }

    /* initializes kennels as a 3x3 2D array */
    public Shelter() {
        kennels = new Dog[3][3];
    }

    // getters and setters
    public Dog[][] getKennels() {
        return kennels;
    }

    public void setKennels(Dog[][] kennels) {
        this.kennels = kennels;
    }

    // methods

    /*
     * prints out the 2D array 'kennels', displaying the dog's info if the kennel is
     * occupied, or
     * 'empty' if the kennel is empty
     */
    public void displayStatus() {
        for (Dog[] row : kennels) {
            for (Dog animal : row) {
                if (animal != null) {
                    System.out.print(animal);
                } else {
                    System.out.print("[Empty]");
                }
            }
            System.out.println();
        }
    }

    public void add(Dog animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        for (int r = 0; r < kennels.length; r++) {
            for (int c = 0; c < kennels[r].length; c++) {
                if (kennels[r][c] == null) {
                    kennels[r][c] = animal;
                    c = kennels[r].length;
                    r = kennels.length - 1;
                }
            }
        }
        if (kennels[kennels.length - 1][kennels[kennels.length - 1].length - 1] != null) {
            System.out.println("No empty kennels.");
        }
    }

    public void add(Dog animal, int row, int col) {
        if (animal == null || row > kennels.length || row < 0
                || col > kennels[row].length || col < 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (kennels[row][col] == null) {
            kennels[row][col] = animal;
        } else {
            add(animal);
        }
    }

    public void add(ArrayList<Dog> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        for (int i = 0; i < animals.size(); i++) {
            add(animals.get(i));
        }
    }

    // checking if the position is null last so that it doesnt casue an error if
    // row/col is invalid
    public Dog adopt(int row, int col) {
        if (row > kennels.length || row < 0 || col > kennels[row].length
                || col < 0 || kennels[row][col] == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        Dog adopted = kennels[row][col];
        kennels[row][col] = null;
        return adopted;
    }

    public ArrayList<Dog> search(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        for (Dog[] dogArr : kennels) {
            for (Dog dog : dogArr) {
                if (dog != null) {
                    if (dog.getName().equals(name)) {
                        dogs.add(dog);
                    }
                }
            }
        }
        return dogs;
    }

    public ArrayList<Dog> search(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        for (Dog[] dogArr : kennels) {
            for (Dog dog : dogArr) {
                if (dog != null) {
                    if (dog.getAge() == age) {
                        dogs.add(dog);
                    }
                }
            }
        }
        return dogs;
    }
}
