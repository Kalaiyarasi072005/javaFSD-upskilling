// QuantumAgeValidator.java
import java.util.Scanner;

public class QuantumAgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your quantum age:");
        
        try {
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Age validated. Welcome to the quantum realm!");
        } catch (InvalidQuantumAgeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static void validateAge(int age) throws InvalidQuantumAgeException {
        if (age < 18) {
            throw new InvalidQuantumAgeException("Minimum quantum age is 18");
        } else if (age > 120) {
            throw new InvalidQuantumAgeException("Maximum quantum age is 120");
        }
    }
    
    static class InvalidQuantumAgeException extends Exception {
        public InvalidQuantumAgeException(String message) {
            super(message);
        }
    }
}