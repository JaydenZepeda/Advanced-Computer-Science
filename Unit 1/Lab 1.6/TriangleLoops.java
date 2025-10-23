public class TriangleLoops {
    public static void main(String[] args) {
        // to-do: create a separate tester class
        // to-do: invoke each method at least 2 times in the tester class

        // for example:
        System.out.println(createLetterTriangleUp(3, 'A'));
        System.out.println(createLetterTriangleUp(15, 'B'));

    }

    /*
     * The method returns a String by creating rows of letters. Each row prints a
     * number of letters equal to the row number. The total number of rows printed
     * is determined by numberOfRows.
     * @param numberOfRows the number of rows in the triangle
     * @param letter the letter to be printed
     * @return a String of letters in the shape of a triangle
     */

    // to-do: implement createLetterTriangleUp
    public static String createLetterTriangleUp(int numberOfRows, char letter) {
        String triangle = "";
        int i = 0;
        while (i < numberOfRows) {
            for (int num = 0; num < i + 1; num++) {
                triangle += letter;
            }
            triangle += "\n";
            i++;
        }
        return triangle;
    }

    /*
     * The method returns a String by creating rows of letters. Each row prints a
     * number of letters equal to the total number of rows, descending downward. The
     * total number of rows printed is determined by numberOfRows.
     * @param numberOfRows the number of rows in the triangle
     * @param letter the letter to be printed
     * @return a String of letters in the shape of a triangle
     */
    // to-do: implement createLetterTriangleDown
    public static String createLetterTriangleDown(int numberOfRows, char letter) {
        String triangle = "";
        int i = 0;
        while (i < numberOfRows) {
            for (int num = 0; num < numberOfRows - i; num++) {
                triangle += letter;
            }
            triangle += "\n";
            i++;
        }
        return triangle;
    }

    /*
     * This method returns a String of a number triangle. The number of rows in the
     * triangle is determined by the numberOfRows, and the number used in each row
     * is determined by the row number.
     * @param numberOfRows the number of rows in the triangle
     * @return a String of numbers in the shape of a triangle
     */
    // to-do: implement createNumbersTriangle
    public static String createNumbersTriangle(int numberOfRows) {
        String triangle = "";
        int i = 0;
        while (i < numberOfRows) {
            for (int x = 1; x <= i + 1; x++) {
                triangle += x + " ";
            }
            triangle += "\n";
            i++;
        }
        return triangle;
    }

    /*
     * The method returns a String by creating a pyramid pattern using the alphabet.
     * The method determines the height of the pyramid by using the int
     * numberOfRows.
     * @param numberOfRows the number of rows in the triangle
     * @return a String of letters in the shape of a pyramid
     */
    // to-do: implement createAlphabetTriangle
    public static String createAlphabetTriangle(int numberOfRows) {
        if (numberOfRows > 26) {
            numberOfRows = 26;
        }
        String triangle = "";

        int i = 0;
        while (i < numberOfRows) {
            for (int num = 1; num < numberOfRows - i; num++) {
                triangle += " ";
            }
            char char1 = 'A';
            for (int num = 0; num < i + 1; num++) {
                char1 = (char) ('A' + num);
                triangle += (char) ('A' + num);
            }
            for (int num = 0; num < i + 1; num++) {
                if (num != 0) {
                    triangle += (char) (char1 - num);
                }
            
            }
            // for (int num = 0; num < numberOfRows - i; num++) {
            // triangle += (char) ('A' + num);
            // }
            
            
            triangle += "\n";
            i++;
        }
        return triangle;
    } //('a' + 1 = b)

}