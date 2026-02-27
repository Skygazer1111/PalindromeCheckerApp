import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Usecase3();
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
