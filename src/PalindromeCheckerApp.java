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

        Usecase1();
        Usecase2();
        Usecase3();
        Usecase4();
        Usecase5();
        Usecase6();
        Usecase7();
        Usecase8();
        Usecase9();
        Usecase10();
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
    static void Usecase8() {

    String input = "level";

    // Convert string to linked list
    Node head = null, tail = null;

    for (char c : input.toCharArray()) {
        Node newNode = new Node(c);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Find middle using Fast & Slow pointers
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse second half
    Node prev = null;
    Node current = slow;

    while (current != null) {
        Node nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
    }

    // Compare first and second half
    Node firstHalf = head;
    Node secondHalf = prev;

    boolean isPalindrome = true;

    while (secondHalf != null) {
        if (firstHalf.data != secondHalf.data) {
            isPalindrome = false;
            break;
        }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }

    if (isPalindrome) {
        System.out.println("UC8 Result: \"" + input + "\" is a Palindrome (Singly Linked List Method)");
    } else {
        System.out.println("UC8 Result: \"" + input + "\" is NOT a Palindrome (Singly Linked List Method)");
    }

    System.out.println("--------------------------------------");
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