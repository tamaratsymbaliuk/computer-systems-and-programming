package speedTest;

import static speedTest.MatrixMultiplication.*;
import static speedTest.MatrixMultiplicationDemo.generateMatrixWithRandomNumbers;

public class MatrixMultiplicationSpeedTest {

    public static final int BLOCK_SIZE = 100;
    public static final int WARMUP_COUNT = 1;
    public static final int ITERATION_COUNT = 1;
    public static final int TIME_FACTOR = 1000000;

    public static void main(String[] args) {
        int n = 1000;
        int m = 500;
        int l = 1000;

        int[][] m1 = generateMatrixWithRandomNumbers(n,m);
        int[][] m2 = generateMatrixWithRandomNumbers(m,l);

        int[][] baseResult = new int[n][l];
        int[][] m2Transposed = MatrixMultiplication.transposeMatrix(m2);
        int[][] resultTransposed = new int[n][l];
        int[][] resultBlock = new int[n][l];
        int[][] resultTransposeBlock = new int[n][l];

        long duration1 = averageExecutionTime(() ->
                multiplyMatrices(m1, m2, baseResult), ITERATION_COUNT);
        System.out.println("Execution time of method1  multiplyMatrices: " + duration1 / TIME_FACTOR + " ns");

        long duration3 = averageExecutionTime(() ->
                multiplyMatricesTransposed(m1, m2Transposed, resultTransposed), ITERATION_COUNT);
        System.out.println("Execution time of method2 multiplyMatricesTransposed: " + duration3 / TIME_FACTOR + " ns");

        long duration2 = averageExecutionTime(() ->
                multiplyMatricesBlock(m1, m2, resultBlock, BLOCK_SIZE), ITERATION_COUNT);
        System.out.println("Execution time of method3: multiplyMatricesBlock " + duration2 / TIME_FACTOR + " ns");

        long duration4 = averageExecutionTime(() ->
                multiplyMatricesTransposeBlock(m1, m2Transposed, resultTransposeBlock, BLOCK_SIZE), ITERATION_COUNT);
        System.out.println("Execution time of method4 multiplyMatricesTransposeBlock: " + duration4 / TIME_FACTOR + " ns");

    }

    public static long averageExecutionTime(Runnable method, int iterations) {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            method.run();
        }
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            method.run();
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        return totalTime / iterations;
    }
}
