package Homework_Coding_in_Java_and_Python;

import java.util.Arrays;

public class ReverseArray {

    public String[] reverseArray(String[] text){

        String temp;
        int start = 0;
       int end = text.length - 1;

       while (start < end){

           temp = text[start];
           text[start] = text[end];
           text[end] = temp;
           start++;
           end--;

       }

        return text;
    }


    public static void main(String[] args) {

        String[] someText = {"Some","text","to","revert"};

        ReverseArray test = new ReverseArray();
       String result = Arrays.toString(test.reverseArray(someText));
        System.out.println(result);

    }
}
