package Homework_Coding_in_Java_and_Python;

public class SumAnArray {

    public static void main(String[] args) {


        int sum = 0;
        int[] nums = {3, 4, 5, 6};

        for (int n : nums) {
            sum += n;
        }
        System.out.println("Sum of array: " + sum);

    }
}
