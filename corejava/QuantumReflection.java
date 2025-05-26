// QuantumReflection.java
import java.lang.reflect.*;

public class QuantumReflection {
    private String hiddenState = "Quantum entanglement";

    public void collapseWavefunction() {
        System.out.println("Wavefunction collapsed to: " + hiddenState);
    }

    public static void main(String[] args) throws Exception {
        // Get class metadata
        Class<?> clazz = Class.forName("QuantumReflection");
        System.out.println("Class name: " + clazz.getName());

        // Create instance
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // Access private field
        Field field = clazz.getDeclaredField("hiddenState");
        field.setAccessible(true);
        System.out.println("Hidden state value: " + field.get(instance));

        // Modify private field
        field.set(instance, "Quantum superposition");
        System.out.println("Modified hidden state: " + field.get(instance));

        // Invoke method
        Method method = clazz.getMethod("collapseWavefunction");
        method.invoke(instance);

        // List all methods
        System.out.println("\nAll quantum methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m.getName() + " - " + 
                Modifier.toString(m.getModifiers()));
        }