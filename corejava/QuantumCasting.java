// QuantumCasting.java
public class QuantumCasting {
    public static void main(String[] args) {
        // Quantum superposition (double)
        double quantumState = 42.987654321;
        System.out.println("Original quantum state (double): " + quantumState);
        
        // Collapse to classical state (int)
        int classicalState = (int) quantumState;
        System.out.println("Collapsed state (int): " + classicalState);
        
        // Return to quantum state (double)
        double restoredState = classicalState;
        System.out.println("Restored state (double): " + restoredState);
        
        // Special quantum casting
        System.out.println("\nQuantum Bit Casting:");
        float qFloat = 3.14159f;
        int qBits = Float.floatToIntBits(qFloat);
        System.out.println("Float: " + qFloat + " → Bits: " + qBits);
        System.out.println("Binary: " + Integer.toBinaryString(qBits));
    }
}