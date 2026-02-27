import java.util.*;

public class PalindromeCheckerApp {

    // ===============================
    // UC8 Node Class (Singly Linked List)
    // ===============================
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
        Usecase11();
        Usecase12();   // ✅ Strategy Pattern
    }

    // ================= UC1 =================
    static void Usecase1() {
        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.println("Version 1.0");
        System.out.println("--------------------------------------");
    }

    // ================= UC2 =================
    static void Usecase2() {
        String input = "madam";
        boolean isPalindrome = true;
        int end = input.length() - 1;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(end--)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC2 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC3 =================
    static void Usecase3() {
        String input = "level";
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--)
            reversed += input.charAt(i);

        System.out.println("UC3 Result: " + input.equals(reversed));
        System.out.println("--------------------------------------");
    }

    // ================= UC4 =================
    static void Usecase4() {
        String input = "radar";
        int start = 0, end = input.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC4 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC5 =================
    static void Usecase5() {
        String input = "refer";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray())
            stack.push(c);

        boolean isPalindrome = true;

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC5 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC6 =================
    static void Usecase6() {
        String input = "noon";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC6 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC7 =================
    static void Usecase7() {
        String input = "civic";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            deque.addLast(c);

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC7 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC8 =================
    static void Usecase8() {
        String input = "level";
        Node head = null, tail = null;

        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head, secondHalf = prev;
        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("UC8 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC9 =================
    static void Usecase9() {
        String input = "madam";
        System.out.println("UC9 Result: " + check(input, 0, input.length() - 1));
        System.out.println("--------------------------------------");
    }

    private static boolean check(String s, int start, int end) {
        if (start >= end)
            return true;
        if (s.charAt(start) != s.charAt(end))
            return false;
        return check(s, start + 1, end - 1);
    }

    // ================= UC10 =================
    static void Usecase10() {
        String input = "A man a plan a canal Panama";
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;

        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) !=
                normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC10 Result: " + isPalindrome);
        System.out.println("--------------------------------------");
    }

    // ================= UC11 =================
    static void Usecase11() {
        String input = "racecar";
        PalindromeService service = new PalindromeService();
        System.out.println("UC11 Result: " + service.checkPalindrome(input));
        System.out.println("--------------------------------------");
    }

    // ================= UC12 =================
    static void Usecase12() {

        String input = "level";

        PalindromeStrategy strategy;

        // Choose Strategy (Change here if needed)
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        boolean result = strategy.check(input);

        System.out.println("UC12 Strategy Used: " + strategy.getClass().getSimpleName());
        System.out.println("UC12 Result: " + result);
        System.out.println("--------------------------------------");
    }
}

// ================= UC11 Service Class =================
class PalindromeService {

    public boolean checkPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--))
                return false;
        }

        return true;
    }
}

// ================= UC12 Strategy Interface =================
interface PalindromeStrategy {
    boolean check(String input);
}

// ================= Stack Strategy =================
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray())
            stack.push(c);

        for (char c : input.toCharArray()) {
            if (c != stack.pop())
                return false;
        }

        return true;
    }
}

// ================= Deque Strategy =================
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }

        return true;
    }
}