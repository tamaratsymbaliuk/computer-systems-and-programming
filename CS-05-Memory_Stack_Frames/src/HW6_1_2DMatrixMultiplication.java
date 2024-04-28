public class HW6_1_2DMatrixMultiplication {

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {1, 3, 2}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7}
        };


        // Validate if multiplication is possible
        //Two matrices are multiplicable if the number of coloumns in the first matrix is equal to the number of rows
        // in the second matrix.
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Matrix multiplication is not possible!");
            return;
        }

        System.out.println("Result of Matrix Multiplication: ");
        int[][] resultMatrix = multiplyMatrices(matrix1, matrix2);
        printMatrix(resultMatrix);
    }

    private static void printMatrix(int[][] resultMatrix) {
        for (int[] row : resultMatrix){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();

        }
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int mat1Rows = matrix1.length;
        int mat1Cols = matrix1[0].length;
        int mat2Cols = matrix2[0].length;

        int[][] result = new int[mat1Rows][mat2Cols];

        //multiplying matrices
        for (int i = 0; i < mat1Rows; i++) {
            for (int j = 0; j < mat2Cols; j++){
                for (int k = 0; k < mat1Cols; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;


    }
}
