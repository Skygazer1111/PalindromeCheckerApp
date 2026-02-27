import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Usecase4();
    }
    static void Usecase4() {

        String input = "radar";

        // Convert to char array
        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        // Two-pointer technique
        while (start < end) {

            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("UC4 Result: \"" + input + "\" is a Palindrome (Two Pointer Method)");
        } else {
            System.out.println("UC4 Result: \"" + input + "\" is NOT a Palindrome (Two Pointer Method)");
        }

        System.out.println("--------------------------------------");
    }    

}
