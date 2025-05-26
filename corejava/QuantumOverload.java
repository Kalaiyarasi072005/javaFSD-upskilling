// QuantumOverload.java
public class QuantumOverload {
    // Quantum addition methods
    public static String add(int a, int b) {
        return String.format("Integer sum: %d + %d = %d", a, b, a + b);
    }
    
    public static String add(double x, double y) {
        return String.format("Double sum: %.2f + %.2f = %.2f", x, y, x + y);
    }
    
    public static String add(int a, int b, int c) {
        return String.format("Triple sum: %d + %d + %d = %d", a, b, c, a + b + c);
    }
    
    public static String add(String s1, String s2) {
        return String.format("String concatenation: \"%s\" + \"%s\" = \"%s\"", s1, s2, s1 + s2);
    }
    
    public static void main(String[] args) {
        System.out.println("Quantum Method Overloading Demonstration:");
        System.out.println(add(5, 7));
        System.out.println(add(3.14, 2.71));
        System.out.println(add(10, 20, 30));
        System.out.println(add("Quantum", "Mechanics"));
        
        // Extra: Varargs example
        System.out.println("\nQuantum Sum of 1,2,3,4,5: " + sum(1,2,3,4,5));
    }
    
    // Bonus: Varargs method
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}