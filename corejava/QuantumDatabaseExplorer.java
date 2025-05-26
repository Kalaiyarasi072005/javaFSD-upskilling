// QuantumDatabaseExplorer.java
import java.sql.*;

public class QuantumDatabaseExplorer {
    private static final String QUANTUM_DB_URL = "jdbc:mysql://localhost:3306/quantum_lab";
    private static final String USERNAME = "quantum_researcher";
    private static final String PASSWORD = "He1s3nb3rg";

    public static void main(String[] args) {
        System.out.println("Quantum Database Exploration Initiated...");
        
        try (Connection quantumConnection = DriverManager.getConnection(
                QUANTUM_DB_URL, USERNAME, PASSWORD)) {
            
            System.out.println("Quantum Entanglement Established with Database");
            
            exploreParticlesTable(quantumConnection);
            displaySuperpositionStates(quantumConnection);
            
        } catch (SQLException e) {
            System.err.println("Quantum Connection Collapse: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void exploreParticlesTable(Connection conn) throws SQLException {
        String quantumQuery = "SELECT particle_name, spin, mass_mev FROM quantum_particles " +
                             "WHERE mass_mev > 1 ORDER BY particle_name";
        
        try (Statement stmt = conn.createStatement();
             ResultSet quantumResults = stmt.executeQuery(quantumQuery)) {
            
            System.out.println("\nQuantum Particles Catalog:");
            System.out.println("----------------------------------");
            System.out.printf("%-20s %-8s %-10s%n", "Particle", "Spin", "Mass (MeV)");
            System.out.println("----------------------------------");
            
            while (quantumResults.next()) {
                String name = quantumResults.getString("particle_name");
                String spin = quantumResults.getString("spin");
                double mass = quantumResults.getDouble("mass_mev");
                
                System.out.printf("%-20s %-8s %-10.2f%n", name, spin, mass);
            }
        }
    }

    private static void displaySuperpositionStates(Connection conn) throws SQLException {
        String stateQuery = "SELECT state_id, probability FROM superposition_states " +
                           "WHERE probability > 0.1";
        
        try (PreparedStatement pstmt = conn.prepareStatement(stateQuery);
             ResultSet stateResults = pstmt.executeQuery()) {
            
            System.out.println("\nSuperposition Probability States:");
            System.out.println("----------------------------------");
            
            while (stateResults.next()) {
                int stateId = stateResults.getInt("state_id");
                double probability = stateResults.getDouble("probability");
                
                System.out.printf("State %d: %.2f%% superposition probability%n", 
                    stateId, probability * 100);
            }
        }
    }
}