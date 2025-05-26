// QuantumTypes.java
public class QuantumTypes {
    public static void main(String[] args) {
        // Quantum data types
        byte quantumByte = 127; // Max value
        short quantumShort = 32767; // Max value
        int quantumInt = 2_147_483_647; // Max value
        long quantumLong = 9_223_372_036_854_775_807L; // Max value
        float quantumFloat = 3.4028235E38f; // Max value
        double quantumDouble = 1.7976931348623157E308; // Max value
        char quantumChar = '\u03A8'; // Psi symbol
        boolean quantumBoolean = true;
        
        System.out.println("Quantum Data Type Demonstration:");
        System.out.println("Byte: " + quantumByte);
        System.out.println("Short: " + quantumShort);
        System.out.println("Int: " + quantumInt);
        System.out.println("Long: " + quantumLong);
        System.out.println("Float: " + quantumFloat);
        System.out.println("Double: " + quantumDouble);
        System.out.println("Char: " + quantumChar);
        System.out.println("Boolean: " + quantumBoolean);
        
        // Show binary representations
        System.out.println("\nBinary Representations:");
        System.out.println("Byte: " + Integer.toBinaryString(quantumByte & 0xFF));
        System.out.println("Char: " + Integer.toBinaryString(quantumChar));
    }
}