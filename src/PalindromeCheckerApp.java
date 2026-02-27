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

    
        Usecase8();
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
    

}
