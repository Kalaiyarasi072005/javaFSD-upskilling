// QuantumTable.java
import java.util.Scanner;

public class QuantumTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a quantum multiplier:");
        int number = scanner.nextInt();
        
        System.out.println("Quantum Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d × %d = %d%n", number, i, number * i);
        }
        
        // Extra: Show table in reverse
        System.out.println("\nReverse quantum entanglement:");
        for (int i = 10; i >= 1; i--) {
            System.out.printf("%d ÷ %d = %.2f%n", number * i, number, (double)(number * i) / number);
        }
    }
}