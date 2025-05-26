// QuantumStudents.java
import java.util.ArrayList;
import java.util.Scanner;

public class QuantumStudents {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter quantum student names (type 'exit' to finish):");
        
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            students.add(name);
        }
        
        System.out.println("\nQuantum Student Roster:");
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, students.get(i));
        }
        
        // Extra: Random student selector
        if (!students.isEmpty()) {
            System.out.println("\nRandom student selector:");
            String randomStudent = students.get((int)(Math.random() * students.size()));
            System.out.println("Today's quantum presenter: " + randomStudent);
        }
    }
}