package speedTest;

import java.util.stream.IntStream;

public class CacheMemorySpeedTest {
    public static final int TIME_SCALE = 1000000;

    public static void main(String[] args) {
        int size = 10000;
        int[][] matrix = new int[size][size];
        int numberOfExecutions = 10;

        Runnable task = () -> {
            // Cache-unfriendly access
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = i + j;
                }
            }
            long endTime = System.nanoTime();
            System.out.println("Column-major access time: " + (endTime - startTime / TIME_SCALE + " ms"));

            //Cache-friendly access
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = i + j;
                }
            }
            endTime = System.nanoTime();
            System.out.println("Row-major access time " + (endTime - startTime) / TIME_SCALE + " ms");
        };
        IntStream.range(0, numberOfExecutions).forEach((_ -> task.run()));
    }
}
