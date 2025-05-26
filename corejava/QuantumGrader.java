// QuantumGrader.java
import java.util.Scanner;

public class QuantumGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter quantum performance score (0-100):");
        int score = scanner.nextInt();
        
        String grade;
        if (score >= 90) grade = "A (Quantum Excellence)";
        else if (score >= 80) grade = "B (Superposition Master)";
        else if (score >= 70) grade = "C (Wavefunction Standard)";
        else if (score >= 60) grade = "D (Particle Level)";
        else grade = "F (Quantum Collapse)";
        
        System.out.println("Your grade: " + grade);
        
        // Extra: Show grade distribution
        System.out.println("\nQuantum Grade Distribution:");
        System.out.println("A: 90-100 (Quantum Excellence)");
        System.out.println("B: 80-89 (Superposition Master)");
        System.out.println("C: 70-79 (Wavefunction Standard)");
        System.out.println("D: 60-69 (Particle Level)");
        System.out.println("F: 0-59 (Quantum Collapse)");
    }
}