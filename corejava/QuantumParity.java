// QuantumParity.java
import java.util.Scanner;

public class QuantumParity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a quantum integer:");
        int number = scanner.nextInt();
        
        String result = (number & 1) == 0 ? 
            "The quantum state is EVEN (wave-like)" : 
            "The quantum state is ODD (particle-like)";
        
        System.out.println(result);
        System.out.println("Binary representation: " + Integer.toBinaryString(number));
    }
}