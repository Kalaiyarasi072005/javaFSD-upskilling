// QuantumRecords.java
import java.util.List;

public class QuantumRecords {
    public record QuantumParticle(String name, double mass, int charge) {
        public String description() {
            return String.format("%s (mass: %.3f, charge: %d)", 
                name, mass, charge);
        }
    }
    
    public static void main(String[] args) {
        QuantumParticle electron = new QuantumParticle("Electron", 0.511, -1);
        QuantumParticle proton = new QuantumParticle("Proton", 938.272, 1);
        QuantumParticle neutron = new QuantumParticle("Neutron", 939.565, 0);
        
        System.out.println(electron.description());
        System.out.println(proton);
        System.out.println(neutron);
        
        // Using with to create modified copies
        QuantumParticle positron = electron.withCharge(1);
        System.out.println("\nAntiparticle: " + positron);
        
        // List of records
        List<QuantumParticle> standardModel = List.of(
            electron, proton, neutron,
            new QuantumParticle("Photon", 0, 0),
            new QuantumParticle("Gluon", 0, 0)
        );
        
        System.out.println("\nStandard Model Particles:");
        standardModel.stream()
            .filter(p -> p.mass() > 0)
            .forEach(System.out::println);
    }
    
    // Helper method for demonstration (not part of record)
    static QuantumParticle withCharge(QuantumParticle particle, int newCharge) {
        return new QuantumParticle(particle.name(), particle.mass(), newCharge);
    }
}