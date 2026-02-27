import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Usecase2();
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
}
