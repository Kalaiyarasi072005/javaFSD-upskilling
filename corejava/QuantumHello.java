// QuantumHello.java
public class QuantumHello {
    public static void main(String[] args) {
        String greeting = "Hello from the Quantum Realm!";
        String version = "Java " + System.getProperty("java.version");
        System.out.println(greeting);
        System.out.println("Running on: " + version);
        System.out.println("Current time: " + new java.util.Date());
    }
}