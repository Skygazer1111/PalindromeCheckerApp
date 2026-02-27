import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import org.w3c.dom.Node;

// UC8 Node class (Singly Linked List)


public class PalindromeCheckerApp {
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

      
        Usecase10();
    }

    
     static void Usecase10() {

        String input = "A man a plan a canal Panama";

        // Normalize string (remove spaces & symbols, convert to lowercase)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;

        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i) !=
                normalized.charAt(normalized.length() - 1 - i)) {

                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC10 Input: " + input);
        System.out.println("Normalized: " + normalized);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("--------------------------------------");
    }
    

}
