// QuantumChat.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class QuantumChat {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java QuantumChat <server|client>");
            return;
        }

        if (args[0].equalsIgnoreCase("server")) {
            runServer();
        } else if (args[0].equalsIgnoreCase("client")) {
            runClient();
        }
    }

    private static void runServer() throws IOException {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Quantum chat server waiting for connection...");
            try (Socket client = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 Scanner scanner = new Scanner(System.in)) {

                System.out.println("Client connected from " + client.getInetAddress());
                System.out.println("Type 'exit' to quit");

                new Thread(() -> {
                    try {
                        String input;
                        while ((input = in.readLine()) != null) {
                            System.out.println("Client: " + input);
                            if (input.equalsIgnoreCase("exit")) break;
                        }
                    } catch (IOException e) {
                        System.err.println("Quantum connection error: " + e.getMessage());
                    }
                }).start();

                String output;
                while (true) {
                    output = scanner.nextLine();
                    out.println(output);
                    if (output.equalsIgnoreCase("exit")) break;
                }
            }
        }
    }

    private static void runClient() throws IOException {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to quantum chat server");
            System.out.println("Type 'exit' to quit");

            new Thread(() -> {
                try {
                    String input;
                    while ((input = in.readLine()) != null) {
                        System.out.println("Server: " + input);
                        if (input.equalsIgnoreCase("exit")) break;
                    }
                } catch (IOException e) {
                    System.err.println("Quantum connection error: " + e.getMessage());
                }
            }).start();

            String output;
            while (true) {
                output = scanner.nextLine();
                out.println(output);
                if (output.equalsIgnoreCase("exit")) break;
            }
        }
    }
}