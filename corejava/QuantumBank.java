// QuantumBank.java
import java.sql.*;
import java.util.Scanner;

public class QuantumBank {
    private static final String URL = "jdbc:mysql://localhost:3306/quantum_db";
    private static final String USER = "quantum_user";
    private static final String PASS = "superposition";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source account ID:");
        int fromId = scanner.nextInt();
        System.out.println("Enter target account ID:");
        int toId = scanner.nextInt();
        System.out.println("Enter quantum amount to transfer:");
        double amount = scanner.nextDouble();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            conn.setAutoCommit(false); // Start transaction

            try {
                // Check if accounts exist
                if (!accountExists(conn, fromId) || !accountExists(conn, toId)) {
                    throw new SQLException("One or more accounts don't exist");
                }

                // Withdraw from source
                withdraw(conn, fromId, amount);
                
                // Deposit to target
                deposit(conn, toId, amount);
                
                conn.commit();
                System.out.println("Quantum transfer completed successfully!");
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Quantum transfer failed: " + e.getMessage());
                System.out.println("Transaction rolled back");
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    private static boolean accountExists(Connection conn, int id) throws SQLException {
        String sql = "SELECT 1 FROM accounts WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private static void withdraw(Connection conn, int id, double amount) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, id);
            stmt.setDouble(3, amount);
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Insufficient quantum funds or account not found");
            }
        }
    }

    private static void deposit(Connection conn, int id, double amount) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}