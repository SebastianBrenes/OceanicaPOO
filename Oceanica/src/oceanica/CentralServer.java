package oceanica;

/**
 *
 * @author Portatil_HP
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CentralServer {

    private static final List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Puerto para la comunicación de sockets
            System.out.println("Servidor central iniciado. Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Esperar a que una instancia del programa se conecte
                System.out.println("Nueva conexión: " + clientSocket);

                // Crear un escritor de salida para enviar mensajes al cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out); // Agregar el escritor de salida a la lista de clientes

                // Crear un hilo para manejar la comunicación con el cliente
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hilo para manejar la comunicación con un cliente
    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Crear un lector de entrada para recibir mensajes del cliente
                Scanner in = new Scanner(clientSocket.getInputStream());
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Mensaje recibido: " + message);

                    // Reenviar el mensaje a todos los clientes conectados
                    for (PrintWriter client : clients) {
                        client.println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
