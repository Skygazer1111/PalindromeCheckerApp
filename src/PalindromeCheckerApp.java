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

        
        Usecase9();
    }

   
static void Usecase9() {

        String input = "madam";

        boolean result = check(input, 0, input.length() - 1);

        System.out.println("UC9 Input: " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println("--------------------------------------");
    }

    // Recursive Method
    private static boolean check(String s, int start, int end) {

        // Base Condition
        if (start >= end)
            return true;

        // If mismatch
        if (s.charAt(start) != s.charAt(end))
            return false;

        // Recursive Call
        return check(s, start + 1, end - 1);
    }
    

}
