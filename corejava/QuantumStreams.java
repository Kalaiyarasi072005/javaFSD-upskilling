// QuantumStreams.java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuantumStreams {
    public static void main(String[] args) {
        List<Integer> quantumNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original quantum numbers: " + quantumNumbers);
        
        // Filter even numbers
        List<Integer> evens = quantumNumbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even quantum numbers: " + evens);
        
        // Square each number
        List<Integer> squares = quantumNumbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squared quantum numbers: " + squares);
        
        // Sum all numbers
        int sum = quantumNumbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Quantum sum: " + sum);
        
        // Find max
        int max = quantumNumbers.stream()
            .max(Integer::compare)
            .orElse(0);
        System.out.println("Maximum quantum value: " + max);
        
        // Collect to string
        String joined = quantumNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" -> "));
        System.out.println("Quantum sequence: " + joined);
    }
}