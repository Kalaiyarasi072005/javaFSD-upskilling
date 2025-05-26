// QuantumLambda.java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuantumLambda {
    public static void main(String[] args) {
        List<String> particles = Arrays.asList(
            "Photon", "Electron", "Proton", "Neutron", "Quark",
            "Gluon", "Boson", "Fermion", "Lepton", "Hadron"
        );
        
        System.out.println("Original quantum particles:");
        particles.forEach(System.out::println);
        
        // Sort with lambda
        particles.sort((a, b) -> a.length() - b.length());
        System.out.println("\nSorted by quantum length:");
        particles.forEach(System.out::println);
        
        // Filter with lambda
        List<String> filtered = particles.stream()
            .filter(p -> p.startsWith("Q") || p.startsWith("B"))
            .collect(Collectors.toList());
        
        System.out.println("\nFiltered quantum particles (Q or B):");
        filtered.forEach(System.out::println);
        
        // Map with lambda
        List<String> excited = particles.stream()
            .map(p -> "Excited " + p)
            .collect(Collectors.toList());
        
        System.out.println("\nExcited quantum particles:");
        excited.forEach(System.out::println);
    }
}