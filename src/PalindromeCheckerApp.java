import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Usecase1();
        Usecase2();
        Usecase3();
    }

    static void Usecase1() {
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version 1.0");
        System.out.println("System initialized Successfully");
    }

    static void Usecase2() {

        String input = "madam";
        char[] test = input.toCharArray();

        int end = input.length() - 1;   // renamed from n (safer)
        boolean isPalindrome = true;    // better approach than j=0/1

        for (int i = 0; i < input.length() / 2; i++) {

            if (test[i] != test[end]) {
                isPalindrome = false;
                break;
            }

            end--;
        }

        if (isPalindrome) {
            System.out.println("The String is palindrome");
        } else {
            System.out.println("The String is not palindrome");
        }
    }
    static void Usecase3() {

        // Hardcoded string
        String input = "level";

        // Reverse string using loop
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Compare original and reversed using equals()
        if (input.equals(reversed)) {
            System.out.println("UC3 Result: \"" + input + "\" is a Palindrome (Reverse Method)");
        } else {
            System.out.println("UC3 Result: \"" + input + "\" is NOT a Palindrome (Reverse Method)");
        }
    }    

}