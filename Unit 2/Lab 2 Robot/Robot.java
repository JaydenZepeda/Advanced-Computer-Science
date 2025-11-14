public class Robot {
    // to-do: change file name, class, and constructor to Robot

    private int[] hallway;
    private int position; // the robot's current position
    private boolean isFacingRight; // true if the robot is facing right

    public Robot(int[] hallwayToClean, int startingPosition) {
        if (startingPosition < 0) {
            startingPosition = 0;
        }
        if (startingPosition > hallwayToClean.length - 1) {
            startingPosition = hallwayToClean.length - 1;
        }
        for (int i = 0; i < hallwayToClean.length; i++) {
            if (hallwayToClean[i] < 0) {
                hallwayToClean[i] = 0;
            }
        }
        this.hallway = hallwayToClean;
        this.position = startingPosition;
        this.isFacingRight = true;
    }

    public int[] getHallway() {
        return hallway;
    }


    public void setHallway(int[] hallway) {
        this.hallway = hallway;
    }


    public int getPosition() {
        return position;
    }


    public void setPosition(int position) {
        this.position = position;
    }


    public boolean isFacingRight() {
        return isFacingRight;
    }


    public void setFacingRight(boolean isFacingRight) {
        this.isFacingRight = isFacingRight;
    }

    /*
     * Determines if the robot is blocked by a wall (the end of an array)
     * 
     * @return true if the robot is blocked by a wall, false otherwise
     */
    public boolean isRobotBlockedByWall() {
        if ((isFacingRight && position == hallway.length - 1) || (!isFacingRight && position == 0)) {
            return true;
        }
        return false;
    }

    /*
     * Commands the robot to pick up an item, move forward or turn around
     */
    public void move() {
        if (hallway[position] > 1) {
            hallway[position]--;
        } else if (hallway[position] == 1) {
            hallway[position]--;
            if (isRobotBlockedByWall()) {
                if (isFacingRight) {
                    isFacingRight = false;
                } else {
                    isFacingRight = true;
                }
            } else {
                if (isFacingRight)
            }
        }

    }

    /**
     * This method displays the current state of the robot and the hallway. It then
     * calls the move() method and counts the number of moves it takes to clear the
     * hallway. The method should display the current state of the robot after each
     * move.
     * 
     * @return the number of moves made
     */

    public int clearHall() {
        int count = 0;
        while (!hallIsClear()) {
            move();
            count++;
        }
        return count;
    }

    /**
     * This method determines if the hallway contains any items.
     * 
     * @return a boolean value indicating if the hallway contains any items
     */
    public boolean hallIsClear() {
        boolean zero = true;
        for (int i = 0; i < hallway.length; i++) {
            if (hallway[i] == 0) {
                zero = true;
            }
            if (hallway[i] != 0) {
                zero = false;
                i = hallway.length;
                return zero;
            }
        }
        return zero;
    }

    /*
     * Displays the current state of the robot and the hallway.
     */
    public void displayState() {
        String string = "";
        for (int i = 0; i < hallway.length; i++) {
            string += hallway[i] + " ";
        }
        if (isFacingRight) {
            System.out.println(string + "\n  >");
        } else if (!isFacingRight) {
            System.out.println(string + "\n  <");
        }

    }
}
