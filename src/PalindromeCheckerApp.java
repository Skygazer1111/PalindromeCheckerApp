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

       
        Usecase12();   // ✅ Strategy Pattern
    }

    // ================= UC1 =================
    

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
