package speedTest;

import java.util.Random;

public class MatrixMultiplicationDemo {

    public  static final int BLOCK_SIZE = 1;
    public static final int VALUE_RANGE = 10;

    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int l = 2;

        int[][] m1 = generateMatrixWithRandomNumbers(n,m);
        int[][] m2 = generateMatrixWithRandomNumbers(n,l);

        int[][] baseResult = new int[n][l];
        MatrixMultiplication.multiplyMatrices(m1, m2, baseResult);

        printMatrix(m1,"M1");
        printMatrix(m2,"M2");
        printMatrix(baseResult,"Result");

        int[][] m2Transposed = MatrixMultiplication.transposeMatrix(m2);
        int[][] resultTransposed = new int[n][l];
        MatrixMultiplication.multiplyMatricesTransposed(m1, m2Transposed, resultTransposed);

        int[][] resultBlock = new int[n][l];
        MatrixMultiplication.multiplyMatricesBlock(m1, m2, resultBlock, BLOCK_SIZE);

        int[][] resultTransposeBlock = new int[n][l];
        MatrixMultiplication.multiplyMatricesTransposeBlock(m1, m2Transposed, resultTransposeBlock, BLOCK_SIZE);

        assertEquality(baseResult,"R", resultTransposed, "TransposedR");
        assertEquality(baseResult, "R", resultBlock, "Block");
        assertEquality(baseResult, "R", resultTransposeBlock, "TransposedBlock");
    }

    public static boolean areMatricesEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] generateMatrixWithRandomNumbers(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                matrix[i][j] = random.nextInt(VALUE_RANGE);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, String name) {
        System.out.println("Matrix " + name);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    public static void assertEquality(int[][] m1, String nameM1, int[][] m2, String nameM2){
        if (!areMatricesEqual(m1,m2)){
            System.out.println("Assertion failed. Matrices are not equal:");
            printMatrix(m1, nameM1);
            printMatrix(m2, nameM2);
            throw new IllegalArgumentException("Matrices expected to be equal.");
        }

    }
}


