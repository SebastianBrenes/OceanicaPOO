package oceanica;

/**
 *
 * @author Portatil_HP
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Oceanica extends JFrame {

    private JTextArea consoleTextArea;
    private JTextField commandTextField;
    private PrintWriter out;
    private Socket socket;
    private String username;

    public Oceanica(String username) {
        super("Oceanica: Civilizaciones Submarinas - Usuario: " + username);

        this.username = username;

        // Configurar la ventana principal
        setSize(800, 600); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un panel para la interfaz gráfica
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Crear un área de texto para la consola
        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false); // Hacer el área de texto no editable
        JScrollPane scrollPane = new JScrollPane(consoleTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear un panel para los controles de comandos
        JPanel commandPanel = new JPanel(new BorderLayout());
        panel.add(commandPanel, BorderLayout.SOUTH);

        // Crear un campo de texto para los comandos
        commandTextField = new JTextField();
        commandTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(commandTextField.getText()); // Enviar el mensaje al servidor central
                commandTextField.setText(""); // Limpiar el campo de texto después de enviar el mensaje
            }
        });
        commandPanel.add(commandTextField, BorderLayout.CENTER);

        // Crear un botón para enviar el comando
        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(commandTextField.getText()); // Enviar el mensaje al servidor central
                commandTextField.setText(""); // Limpiar el campo de texto después de enviar el mensaje
            }
        });
        commandPanel.add(sendButton, BorderLayout.EAST);

        // Conectar al servidor central en un hilo separado
        new Thread(new ClientThread()).start();

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para enviar un mensaje al servidor central
    private void sendMessage(String message) {
        if (out != null) {
            out.println(username + ": " + message);
            out.flush();
        }
    }

    // Hilo para manejar la comunicación con el servidor central
    private class ClientThread implements Runnable {

        @Override
        public void run() {
            try {
                socket = new Socket("localhost", 12345); // Conectar al servidor central
                out = new PrintWriter(socket.getOutputStream(), true);

                // Crear un lector de entrada para recibir mensajes del servidor central
                Scanner in = new Scanner(socket.getInputStream());
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    consoleTextArea.append("< " + message + "\n");
                }

                // Cerrar los recursos
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Pedir al usuario que ingrese su nombre de usuario
        String username = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        if (username != null && !username.isEmpty()) {
            SwingUtilities.invokeLater(() -> new Oceanica(username));
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario no válido. Saliendo del programa.");
        }
    }
}

