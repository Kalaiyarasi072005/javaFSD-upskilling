// QuantumRegistry.java
import java.util.HashMap;
import java.util.Scanner;

public class QuantumRegistry {
    public static void main(String[] args) {
        HashMap<Integer, String> studentRegistry = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Quantum Student Registration System");
        
        while (true) {
            System.out.println("\n1. Add student\n2. Find student\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    studentRegistry.put(id, name);
                    System.out.println("Student registered!");
                    break;
                    
                case 2:
                    System.out.println("Enter student ID to find:");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    String foundName = studentRegistry.get(searchId);
                    if (foundName != null) {
                        System.out.println("Student found: " + foundName);
                    } else {
                        System.out.println("No student with that ID");
                    }
                    break;
                    
                case 3:
                    System.out.println("Quantum registry closed");
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}