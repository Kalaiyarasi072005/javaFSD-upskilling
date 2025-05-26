// QuantumGuess.java
import java.util.Scanner;
import java.util.Random;

public class QuantumGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        int attempts = 0;
        final int maxAttempts = 7;
        
        System.out.println("Welcome to Quantum Guessing Game!");
        System.out.println("I've collapsed a quantum state between 1 and 100...");
        
        while (attempts < maxAttempts) {
            System.out.printf("Attempt %d/%d: Enter your guess: ", attempts + 1, maxAttempts);
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess == secret) {
                System.out.printf("Perfect observation! You collapsed the state to %d in %d attempts!%n", secret, attempts);
                return;
            } else if (guess < secret) {
                System.out.println("Your observation is too low (wavefunction not collapsed enough)");
            } else {
                System.out.println("Your observation is too high (over-collapsed the wavefunction)");
            }
        }
        
        System.out.printf("Quantum decoherence occurred! The secret state was %d%n", secret);
    }
}