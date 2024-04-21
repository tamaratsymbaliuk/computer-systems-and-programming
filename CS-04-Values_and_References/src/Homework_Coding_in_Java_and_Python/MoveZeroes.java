package Homework_Coding_in_Java_and_Python;

import java.util.Arrays;

public class MoveZeroes {

    public static int[] moveZeroes(int[] nums){
        int length = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) continue;
            nums[length] = nums[i];
            length++;
        }

        while ( length < nums.length){
            nums[length] = 0;
            length++;
        }
        return Arrays.copyOf(nums,length);
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,2,5,6,0};
        int[] result = moveZeroes(nums);
        System.out.println(Arrays.toString(result));
    }

}
