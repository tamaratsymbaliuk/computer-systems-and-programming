package Homework_Coding_in_Java_and_Python;

public class IsPalindrom {

    public boolean checkIfStringIsPalindrom (String word){
        boolean result =true;
        int first = 0;
        int last = word.length()-1;

        while (first < last){
            if (word.charAt(first) != word.charAt(last)){
                result = false;
                break;
            }
            first++;
            last--;
        }

        return  result;
        //The time complexity is On/2 = O(n);
        //The space complexity is O(1)
    }

    public static void main(String[] args) {
        String word= "level"; // test
        IsPalindrom test = new IsPalindrom();
        boolean result = test.checkIfStringIsPalindrom(word);
        System.out.println(result);

    }

}
