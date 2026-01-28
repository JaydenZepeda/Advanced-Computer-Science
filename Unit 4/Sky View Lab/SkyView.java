public class SkyView {
    private double[][] view;

    public SkyView(int numberOfRows, int numberOfCols, double[] scanned) {
        if (numberOfCols < 0 || numberOfRows < 0 || scanned.length != numberOfRows * numberOfCols) {
            throw new IllegalArgumentException("Invalid Input");
        }
        view = new double[numberOfRows][numberOfCols];
        int i = 0;
        for (int r = 0; r < numberOfRows; r++) {
            if (r % 2 == 1) {
                for (int c = view[r].length - 1; c >= 0; c--) {
                    view[r][c] = scanned[i];
                    i++;
                }
            } else {
                for (int c = 0; c < view[r].length; c++) {
                    view[r][c] = scanned[i];
                    i++;
                }
            }
        }
    }

    public double[][] getView() {
        return view;
    }

    public void setView(double[][] view) {
        this.view = view;
    }

    public String toString() {
        String str = "";
        for (int r = 0; r < view.length; r++) {
            for (int c = 0; c < view[r].length; c++) {
                str += view[r][c] + " ";
            }
            str += "\n";
        }
        return str;
    }

    public boolean equals(SkyView other) {
        if (other.getView().length != view.length || other.getView()[0].length != view[0].length) {
            return false;
        }
        for (int r = 0; r < view.length; r++) {
            for (int c = 0; c < view[r].length; c++) {
                if (view[r][c] != other.getView()[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol) {
        double avg = 0;
        int count = 0;
        for (int r = 0; r < (endRow - startRow + 1); r++) {
            for (int c = 0; c < (endCol - startCol + 1); c++) {
                avg += view[startRow + r][startCol + c];
                count++;
            }
        }
        return avg / count;
    }

}
