// QuantumDecompile.java
public class QuantumDecompile {
    private final String secret = "Quantum superposition";
    
    public String encrypt(int key) {
        char[] chars = secret.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] ^ key);
        }
        return new String(chars);
    }
    
    public static void main(String[] args) {
        QuantumDecompile qd = new QuantumDecompile();
        System.out.println("Encrypted: " + qd.encrypt(42));
    }
}