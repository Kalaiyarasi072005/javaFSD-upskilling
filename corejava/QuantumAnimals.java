// QuantumAnimals.java
public class QuantumAnimals {
    static class QuantumAnimal {
        protected String name;
        
        public QuantumAnimal(String name) {
            this.name = name;
        }
        
        public void makeSound() {
            System.out.println(name + " makes a quantum sound");
        }
        
        public void teleport() {
            System.out.println(name + " teleports through quantum entanglement");
        }
    }
    
    static class QuantumDog extends QuantumAnimal {
        public QuantumDog(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " barks in superposition");
        }
        
        public void fetch() {
            System.out.println(name + " fetches quantum balls from multiple dimensions");
        }
    }
    
    static class QuantumCat extends QuantumAnimal {
        public QuantumCat(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " meows with quantum uncertainty");
        }
        
        public void sleep() {
            System.out.println(name + " exists in all sleeping states simultaneously");
        }
    }
    
    public static void main(String[] args) {
        QuantumAnimal schrodinger = new QuantumCat("Schrödinger");
        QuantumAnimal fermi = new QuantumDog("Fermi");
        QuantumAnimal particle = new QuantumAnimal("Generic Quantum Particle");
        
        schrodinger.makeSound();
        schrodinger.teleport();
        ((QuantumCat)schrodinger).sleep();
        
        fermi.makeSound();
        fermi.teleport();
        ((QuantumDog)fermi).fetch();
        
        particle.makeSound();
        particle.teleport();
    }
}