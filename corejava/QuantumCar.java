// QuantumCar.java
public class QuantumCar {
    private String make;
    private String model;
    private int year;
    private double quantumEnergy;
    
    public QuantumCar(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.quantumEnergy = 100.0;
    }
    
    public void displayDetails() {
        System.out.printf("%d %s %s%n", year, make, model);
        System.out.printf("Quantum Energy: %.1f%%%n", quantumEnergy);
    }
    
    public void teleport() {
        if (quantumEnergy >= 25.0) {
            quantumEnergy -= 25.0;
            System.out.println("Teleportation successful! Quantum energy remaining: " + quantumEnergy + "%");
        } else {
            System.out.println("Insufficient quantum energy for teleportation!");
        }
    }
    
    public void recharge() {
        quantumEnergy = 100.0;
        System.out.println("Quantum energy fully recharged!");
    }
    
    public static void main(String[] args) {
        QuantumCar car1 = new QuantumCar("Tesla", "Model Q", 2025);
        QuantumCar car2 = new QuantumCar("Ford", "Quantum Focus", 2024);
        
        car1.displayDetails();
        car1.teleport();
        car1.teleport();
        car1.recharge();
        
        car2.displayDetails();
        car2.teleport();
    }
}