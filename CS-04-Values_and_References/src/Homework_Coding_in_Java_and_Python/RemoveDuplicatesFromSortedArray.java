package Homework_Coding_in_Java_and_Python;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int[] removeDuplicates(int[] nums){
        int length = 1; // Length of the non-duplicate part of the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { //check if different
                nums[length++] = nums[i]; // Move the unique number to the next position
            }
        }

        return Arrays.copyOf(nums, length);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,3,3,4,4,4,4,5};
        int[] uniqueNumbers = removeDuplicates(nums);

        System.out.println("Array with duplicates was removed: " + Arrays.toString(uniqueNumbers));
    }


}
