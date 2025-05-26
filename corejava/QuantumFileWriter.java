// QuantumFileWriter.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuantumFileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter quantum data to store:");
        String data = scanner.nextLine();
        
        try (FileWriter writer = new FileWriter("quantum_data.txt", true)) {
            writer.write(data + "\n");
            System.out.println("Quantum data successfully written to file!");
            
            // Add timestamp
            writer.write("Observation time: " + new java.util.Date() + "\n");
        } catch (IOException e) {
            System.err.println("Quantum file error: " + e.getMessage());
        }
    }
}