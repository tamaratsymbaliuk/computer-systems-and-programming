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
                    result[i][j] += matrixA[i][k] * matrixB[k][j];    //0 1 2 3 *
                }                                                    // 1
            }                                                        // 2
        }                                                            // 3
    }

    public static void multiplyMatricesTransposed( //Transposing - converting the rows of a matrix into columns and vice versa
                                                   //so now we need a row from first and a row for second which is much faster
                                                   // than accesing rows from first and columns from second
                                                   //transposed method can keep all arrays in 1 memory (ex. L1). basic multiplication can not fit too many arrays so it access different
                                                   //memory types which is much more time-consuming
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
