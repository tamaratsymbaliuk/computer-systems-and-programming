package speedTest;

public class MatrixMultiplication {
    public static void multiplyMatrices(
            int[][] matrixA, int[][] matrixB, int[][] result) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }

    public static void multiplyMatricesTransposed(
            int[][] matrixA, int[][] transposedMatrixB, int[][] result) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = transposedMatrixB.length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < rowsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * transposedMatrixB[j][k];
                }
            }
        }
    }

    public static void multiplyMatricesBlock(int[][] m1, int[][] m2, int[][] result, int blockSize) {
        int rowsA = m1.length;
        int colsA = m1[0].length;
        int colsB = m2[0].length;

        for (int i = 0; i < rowsA; i+= blockSize) {
            for (int j = 0; j < colsB; j+= blockSize) {
                for (int k = 0; k < colsA; k+= blockSize) {

                    for (int ii = i; ii < Math.min(i + blockSize, rowsA); ii++) {
                        for (int jj = j; jj < Math.min(j + blockSize, colsB); jj++) {
                            for (int kk = k; kk < Math.min(k + blockSize, colsA); kk++) {
                                result[ii][jj] += m1[ii][kk] * m2[kk][jj];
                            }
                        }
                    }
                }
            }
        }
    }

    public static void multiplyMatricesTransposeBlock(int[][] A, int[][] transposedB, int[][] result, int blockSize) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = transposedB.length; // Now rows of B since B is transposed

        for (int i = 0; i < rowsA; i += blockSize) {
            for (int j = 0; j < rowsB; j += blockSize) {
                for (int k = 0; k < colsA; k += blockSize) {

                    for (int ii = i; ii < Math.min(i + blockSize, rowsA); ii++) {
                        for (int jj = j; jj < Math.min(j + blockSize, rowsB); jj++) {
                            for (int kk = k; kk < Math.min(k + blockSize, colsA); kk++) {
                                result[ii][jj] += A[ii][kk] * transposedB[jj][kk];
                            }
                        }
                    }
                }
            }
        }
    }

        public static int[][] transposeMatrix(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int [][] transposed = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }
            return transposed;
        }

}
