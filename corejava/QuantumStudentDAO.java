// QuantumStudentDAO.java
import java.sql.*;
import java.util.Scanner;

public class QuantumStudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/quantum_db";
    private static final String USER = "quantum_user";
    private static final String PASS = "superposition";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            QuantumStudentDAO dao = new QuantumStudentDAO(conn);
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Add student\n2. Update student\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter quantum score:");
                    int score = scanner.nextInt();
                    dao.insertStudent(name, score);
                    break;
                case 2:
                    System.out.println("Enter student ID to update:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new quantum score:");
                    int newScore = scanner.nextInt();
                    dao.updateStudent(id, newName, newScore);
                    break;
            }
        } catch (SQLException e) {
            System.err.println("Quantum database error: " + e.getMessage());
        }
    }

    private Connection connection;

    public QuantumStudentDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertStudent(String name, int quantumScore) throws SQLException {
        String sql = "INSERT INTO students (name, quantum_score) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, quantumScore);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " quantum student(s) added");
        }
    }

    public void updateStudent(int id, String name, int quantumScore) throws SQLException {
        String sql = "UPDATE students SET name = ?, quantum_score = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, quantumScore);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " quantum student(s) updated");
        }
    }
}