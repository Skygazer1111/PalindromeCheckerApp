import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Usecase5();
    }

    static void Usecase5() {

        String input = "refer";

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop and compare
        for (int i = 0; i < input.length(); i++) {

            char popped = stack.pop();

            if (input.charAt(i) != popped) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("UC5 Result: \"" + input + "\" is a Palindrome (Stack Method)");
        } else {
            System.out.println("UC5 Result: \"" + input + "\" is NOT a Palindrome (Stack Method)");
        }

        System.out.println("--------------------------------------");
    }

}
