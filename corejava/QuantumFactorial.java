// QuantumFactorial.java
import java.util.Scanner;

public class QuantumFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a non-negative integer to calculate its quantum factorial:");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Negative numbers cause quantum instability!");
            return;
        }
        
        long result = 1;
        System.out.print(n + "! = ");
        for (int i = 1; i <= n; i++) {
            result *= i;
            System.out.print(i + (i < n ? " × " : " = "));
        }
        System.out.println(result);
        
        // Extra: Show factorial properties
        System.out.println("\nQuantum Factorial Properties:");
        System.out.println("0! = 1 (by definition)");
        System.out.println("5! = 120");
        System.out.println("10! = 3,628,800");
        System.out.println("20! = 2,432,902,008,176,640,000");
    }
}