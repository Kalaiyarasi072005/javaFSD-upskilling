// QuantumCalculator.java
import java.util.Scanner;

public class QuantumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first quantum value:");
        double q1 = scanner.nextDouble();
        System.out.println("Enter second quantum value:");
        double q2 = scanner.nextDouble();
        
        System.out.println("Choose operation:\n1. Entanglement (Addition)\n2. Superposition (Subtraction)\n3. Collapse (Multiplication)\n4. Observation (Division)");
        int choice = scanner.nextInt();
        
        switch(choice) {
            case 1 -> System.out.printf("Result: %.2f%n", q1 + q2);
            case 2 -> System.out.printf("Result: %.2f%n", q1 - q2);
            case 3 -> System.out.printf("Result: %.2f%n", q1 * q2);
            case 4 -> {
                if (q2 != 0) {
                    System.out.printf("Result: %.2f%n", q1 / q2);
                } else {
                    System.out.println("Quantum collapse detected! Cannot divide by zero.");
                }
            }
            default -> System.out.println("Invalid quantum operation");
        }
    }
}