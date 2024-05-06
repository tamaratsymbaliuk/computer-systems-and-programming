package multithreading;

public class MatrixMultiplication {
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultMatrix;

    public MatrixMultiplication(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("Matrix multiplication is not possible");
        }
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];
    }

    public void multiply() {
        int rows = firstMatrix.length;
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            final int row = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < secondMatrix[0].length; j++) {
                        resultMatrix[row][j] = 0;
                        for (int k = 0; k < firstMatrix[0].length; k++) {
                            resultMatrix[row][j] += firstMatrix[row][k] * secondMatrix[k][j];
                        }
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e);
            }
        }
    }

    public void displayResult() {
        for (int[] row : resultMatrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

