// QuantumPrecedence.java
public class QuantumPrecedence {
    public static void main(String[] args) {
        int a = 5, b = 10, c = 15;
        
        System.out.println("Quantum Operator Precedence Demonstration:");
        
        int result1 = a + b * c;
        System.out.println("a + b * c = " + result1 + " (Multiplication first)");
        
        int result2 = (a + b) * c;
        System.out.println("(a + b) * c = " + result2 + " (Parentheses first)");
        
        int result3 = a++ + b * --c;
        System.out.println("a++ + b * --c = " + result3 + " (Pre-decrement, then multiplication, then post-increment)");
        System.out.println("Now a = " + a + ", c = " + c);
        
        // Quantum bitwise operations
        System.out.println("\nQuantum Bitwise Operations:");
        int x = 0b1010; // 10
        int y = 0b1100; // 12
        System.out.println("x & y (AND): " + Integer.toBinaryString(x & y));
        System.out.println("x | y (OR): " + Integer.toBinaryString(x | y));
        System.out.println("x ^ y (XOR): " + Integer.toBinaryString(x ^ y));
    }
}