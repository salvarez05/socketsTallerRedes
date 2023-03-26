import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {

        int serverport = 1100;
        ServerSocket socket;
        Socket misocket;
        try {
            socket = new ServerSocket(serverport);
            System.out.println("Servidor arriba");
            misocket = socket.accept();
            System.out.println("Esperando numero a elevar al cuadrado");
            DataInputStream in = new DataInputStream(misocket.getInputStream());
            String numero = "";
            numero = in.readUTF();
            int numeroapow = Integer.parseInt(numero);
            int pow = (int) Math.pow(numeroapow, 2);
            DataOutputStream out = new DataOutputStream(misocket.getOutputStream());
            out.writeUTF(String.valueOf(pow));
            System.out.println("Numero elevado");
            misocket.close();
            System.out.println("Cliente desconectado");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}

