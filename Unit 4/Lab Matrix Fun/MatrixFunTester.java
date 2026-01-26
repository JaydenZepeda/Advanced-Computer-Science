public class MatrixFunTester {
    public static void main(String[] args) {
        MatrixFun mat = new MatrixFun();
        MatrixFun mat2 = mat;
        System.out.println(mat2.toString());
        System.out.println(mat.toString());
        System.out.println(mat.equals(mat));
    }
}
