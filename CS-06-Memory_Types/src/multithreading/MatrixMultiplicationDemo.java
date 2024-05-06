package multithreading;

public class MatrixMultiplicationDemo {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2},
                {4, 5},
                {1, 3}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {3, 4, 5}
        };

        long startTime = System.currentTimeMillis();

        MatrixMultiplication matrix = new MatrixMultiplication(matrix1, matrix2);
        matrix.multiply();
        matrix.displayResult();

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}

