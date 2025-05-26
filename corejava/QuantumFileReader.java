// QuantumFileReader.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuantumFileReader {
    public static void main(String[] args) {
        System.out.println("Reading quantum data from file...\n");
        
        try (BufferedReader reader = new BufferedReader(new FileReader("quantum_data.txt"))) {
            String line;
            int lineNumber = 1;
            
            while ((line = reader.readLine()) != null) {
                System.out.printf("Line %d: %s%n", lineNumber++, line);
            }
        } catch (IOException e) {
            System.err.println("Quantum read error: " + e.getMessage());
        }
    }
}