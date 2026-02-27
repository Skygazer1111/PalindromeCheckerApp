import java.util.*;

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

       
        Usecase13();   // ✅ Performance Comparison
    }

    
    // ================= UC13 =================
    static void Usecase13() {

        String input = "A man a plan a canal Panama";
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("UC13 Performance Comparison");
        System.out.println("Input Length: " + normalized.length());

        // Two Pointer
        long start = System.nanoTime();
        boolean result1 = twoPointerCheck(normalized);
        long end = System.nanoTime();
        long time1 = end - start;

        // Stack Strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        start = System.nanoTime();
        boolean result2 = stackStrategy.check(normalized);
        end = System.nanoTime();
        long time2 = end - start;

        // Deque Strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        start = System.nanoTime();
        boolean result3 = dequeStrategy.check(normalized);
        end = System.nanoTime();
        long time3 = end - start;

        System.out.println("Two Pointer Time: " + time1 + " ns");
        System.out.println("Stack Strategy Time: " + time2 + " ns");
        System.out.println("Deque Strategy Time: " + time3 + " ns");
        System.out.println("--------------------------------------");
    }

    static boolean twoPointerCheck(String input) {
        int start = 0, end = input.length() - 1;
        while (start < end)
            if (input.charAt(start++) != input.charAt(end--))
                return false;
        return true;
    }
}


}
