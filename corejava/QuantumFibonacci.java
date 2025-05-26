// QuantumFibonacci.java
import java.util.Scanner;

public class QuantumFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the quantum position in Fibonacci sequence:");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Negative positions cause quantum instability!");
            return;
        }
        
        System.out.printf("Fibonacci at position %d is %d%n", n, fibonacci(n));
        
        // Extra: Print sequence up to n
        System.out.println("\nQuantum Fibonacci Sequence:");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}