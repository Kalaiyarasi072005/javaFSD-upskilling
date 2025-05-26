// QuantumSwitch.java
public class QuantumSwitch {
    public static void main(String[] args) {
        Object[] quantumObjects = {
            42,
            "Quantum String",
            3.14159,
            true,
            new int[]{1, 2, 3},
            null
        };
        
        for (Object obj : quantumObjects) {
            String type = switch (obj) {
                case Integer i -> "Integer: " + i;
                case String s -> "String: " + s;
                case Double d -> "Double: " + d;
                case Boolean b -> "Boolean: " + b;
                case int[] array -> "Array: length " + array.length;
                case null -> "Null quantum state";
                default -> "Unknown quantum type";
            };
            System.out.println(type);
        }
        
        // More complex pattern matching
        System.out.println("\nQuantum State Analysis:");
        for (Object obj : quantumObjects) {
            String analysis = switch (obj) {
                case Integer i when i > 50 -> "Large integer: " + i;
                case Integer i -> "Small integer: " + i;
                case String s when s.length() > 10 -> "Long string: " + s;
                case String s -> "Short string: " + s;
                case Double d when d > 1.0 -> "Significant double: " + d;
                case Double d -> "Fractional double: " + d;
                case null -> "Null reference detected";
                default -> "Other quantum object";
            };
            System.out.println(analysis);
        }
    }
}