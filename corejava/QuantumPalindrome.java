// QuantumPalindrome.java
import java.util.Scanner;

public class QuantumPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check for quantum palindrome:");
        String input = scanner.nextLine();
        
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = true;
        
        for (int i = 0; i < clean.length() / 2; i++) {
            if (clean.charAt(i) != clean.charAt(clean.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.printf("\"%s\" is %sa quantum palindrome%n", 
            input, isPalindrome ? "" : "NOT ");
        
        // Extra: Show quantum palindrome properties
        System.out.println("\nQuantum Palindrome Examples:");
        System.out.println("Madam: true");
        System.out.println("A man, a plan, a canal, Panama: true");
        System.out.println("Quantum: false");
    }
}