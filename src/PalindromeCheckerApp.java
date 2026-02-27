import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Usecase6();
    }
    static void Usecase6() {

        String input = "noon";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both structures
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));     // LIFO
            queue.add(input.charAt(i));      // FIFO
        }

        boolean isPalindrome = true;

        // Compare dequeue (queue) vs pop (stack)
        for (int i = 0; i < input.length(); i++) {

            char fromQueue = queue.remove();   // FIFO
            char fromStack = stack.pop();      // LIFO

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC6 Result: \"" + input + "\" is a Palindrome (Queue + Stack Method)");
        } else {
            System.out.println("UC6 Result: \"" + input + "\" is NOT a Palindrome (Queue + Stack Method)");
        }

        System.out.println("--------------------------------------");
    }

}
