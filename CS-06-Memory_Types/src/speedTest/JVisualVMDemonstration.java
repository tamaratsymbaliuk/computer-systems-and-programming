package speedTest;

public class JVisualVMDemonstration {
    public static void main(String[] args) {
        for (long n = 1; n <= 1000000000L; n++) {
            int size = 10000;
            int[][] matrix = new int[size][size];

            for (int k = 0; k < 10; k++){
                for (int i = 0; i < size; i++){
                    for (int j = 0; j < size; j++){
                        matrix[j][i] = i + j;
                    }
                }
            }
        }
    }

}
