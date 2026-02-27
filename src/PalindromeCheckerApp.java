import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

      
        Usecase7();
    }

    static void Usecase7() {

        String input = "civic";

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Remove from both ends and compare
        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC7 Result: \"" + input + "\" is a Palindrome (Deque Method)");
        } else {
            System.out.println("UC7 Result: \"" + input + "\" is NOT a Palindrome (Deque Method)");
        }

        System.out.println("--------------------------------------");
    }

}
