// QuantumArray.java
import java.util.Scanner;

public class QuantumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of quantum elements:");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            System.out.println("Array size must be positive!");
            return;
        }
        
        double[] quantumArray = new double[size];
        System.out.println("Enter " + size + " quantum values:");
        
        for (int i = 0; i < size; i++) {
            quantumArray[i] = scanner.nextDouble();
        }
        
        double sum = 0;
        for (double num : quantumArray) {
            sum += num;
        }
        double average = sum / size;
        
        System.out.printf("Quantum Sum: %.2f%n", sum);
        System.out.printf("Quantum Average: %.2f%n", average);
        
        // Extra: Show variance
        double variance = 0;
        for (double num : quantumArray) {
            variance += Math.pow(num - average, 2);
        }
        variance /= size;
        System.out.printf("Quantum Variance: %.2f%n", variance);
    }
}