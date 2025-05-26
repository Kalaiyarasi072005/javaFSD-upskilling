// QuantumReverse.java
import java.util.Scanner;

public class QuantumReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to quantum reverse:");
        String input = scanner.nextLine();
        
        String reversed = new StringBuilder(input)
            .reverse()
            .toString();
        
        System.out.println("Classical reversal: " + reversed);
        
        // Quantum superposition reversal (alternate characters)
        StringBuilder quantumReversed = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                quantumReversed.append(input.charAt(input.length() - 1 - i/2));
            } else {
                quantumReversed.append(input.charAt(i/2));
            }
        }
        System.out.println("Quantum superposition reversal: " + quantumReversed);
    }
}