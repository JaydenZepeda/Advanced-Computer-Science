public class MatrixFun {
    private int[][] matrix;

    public MatrixFun(int numberOfRows, int numberOfCols) {
        if (numberOfCols <= 0 || numberOfRows <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.matrix = new int[numberOfRows][numberOfCols];
        randNumFill(matrix);
    }

    public MatrixFun(int[][] starterMatrix) {
        isRectangular(starterMatrix);
        this.matrix = starterMatrix;
    }

    public MatrixFun() {
        this.matrix = new int[3][3];
        randNumFill(matrix);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void randNumFill(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = (int) (Math.random() * 10);
            }
        }
    }

    public boolean isRectangular(int[][] starterMatrix) {
        int tempLength = 0;
        for (int r = 0; r < starterMatrix.length; r++) {
            tempLength = starterMatrix[r].length;
            if (starterMatrix[r].length != tempLength) {
                System.out.println("This int[][] is NOT rectangular.");
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String toString = "";
        toString += "=".repeat(matrix[0].length + 1) + "\n";
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                toString += "" + matrix[r][c] + " ";
            }
            toString += "\n";
        }
        toString += "=".repeat(matrix[0].length + 1) + "\n";
        return toString;
    }

    public boolean equals(MatrixFun other) {
        MatrixFun matrix1 = new MatrixFun(matrix);
        if ((matrix1).toString().equals((other).toString())) {
            return true;
        }
        return false;
    }

    public boolean equals(int[][] other) {
        MatrixFun matrix1 = new MatrixFun(matrix);
        MatrixFun matrix2 = new MatrixFun(other);
        if ((matrix1).toString().equals((matrix2).toString())) {
            return true;
        }
        return false;
    }

    public void replaceAll(int oldValue, int newValue) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == oldValue) {
                    matrix[r][c] = newValue;
                }
            }
        }
    }

    public void swapRow(int rowA, int rowB) {
        if (rowA < 0 || rowB < 0 || rowA > matrix.length - 1 || rowB > matrix.length - 1) {
            throw new IllegalArgumentException("Invalid input");
        }
        int[] arrA = matrix[rowA];
        int[] arrB = matrix[rowB];
        matrix[rowA] = arrB;
        matrix[rowB] = arrA;
    }

}
