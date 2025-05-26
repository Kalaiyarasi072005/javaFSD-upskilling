// QuantumThreads.java
public class QuantumThreads {
    public static void main(String[] args) {
        System.out.println("Main quantum thread started");
        
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Quantum Thread 1: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 quantum collapse");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Quantum Thread 2: " + i);
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 quantum collapse");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread quantum collapse");
        }
        
        System.out.println("Main quantum thread completed");
    }
}